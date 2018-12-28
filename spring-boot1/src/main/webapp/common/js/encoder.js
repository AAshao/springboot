/*!
 @Title: encoder
 @Description：对数据进行加密.原理是先对原数据进行MD5加密，然后采用对称3Des进行对称加密。服务端通过密钥进行3Des解密，然后对比MD5值。
               1 对值做MD5的加密   2 对值3DES加密  3 做签名 对数据JSON做签名（MD5+3DES）原理是对jsonkey进行排序，然后组织{bb:5,aa:6}进行串组织成aa6bb5,最后进行MD5加密和3DES加密
 @Author: gn  
 @License：V1.0
 @demo   $("#id").encoder({data:{userNo:'123445',password:'123456'},key:'ssssssssssssss',encType:1});  $("#id").encoder({data:'123456',key:'ssssssssss'});
 */
(function($) {
	
	$.encoder = function(opt){
			var ele=this;
			var fullOpt= $.extend({data:'',key:'',encType:1}, opt || {});
			var data=fullOpt.data;
			var key=fullOpt.key;
			var encType=fullOpt.encType;
			
			if(1==encType){
				return md5(data);
			}
			
			if(2==encType){
				return des(key,data);
			}
			
			if(3==encType){
				return sign(key,data);
			}
		
		
		};
		//md5 进行加密
		function md5(data){
			if(typeof data ==='string'){
			return $.md5(data)
			}else{
				return '-9999仅对string类型进行MD5加密';
			}
		}
		
		//3DES进行加密
		function des(key_,data){
			if(typeof data ==='string'){
				if($.trim(data)==''){
					return '';
				}	
			if(key_.length<24){
				return "-9999密钥为24位";
			}					
			return DES3.encrypt(key_,data);
			}else{
				return '-9999仅对string类型串进行加密';
			}
		}
		//数据签名
		function sign(key_,data){
			if((!( typeof key_ ==='string')||key_=='')){
				return '签名不能为空';
			}
			if(key_.length<24){
				return "-9999密钥为24位";
			}
			if( typeof data ==='string'){
				if(data==''){
					return '';
				}else{
					return DES3.encrypt(key_,$.md5(data));
				}
			}else{
				 var dataArr=[];
				 $.each(data,function(k,v){
					dataArr.push({name:k,value:v}) 	
				 });
				var d=systemSort(dataArr);
				var s="";
		        var n="";
		       for(var i=0;i<d.length;i++){
			      s=s+d[i].name+d[i].value;
		        }
	        //console.info(s);
	           n=$.md5(s);
            //console.info(n);
	            var des3en = DES3.encrypt(key_,n);
	            return des3en;
			}
		}
		
			
function systemSort(array_){
	 return array_.sort(function(a, b) {
		 if(a.name > b.name){
			 return 1; 
		 }else if(a.name == b.name){
			 return 0; 
		 }else{
			 return -1;
		 }
	       
	    });
}
	 
	
})(jQuery);