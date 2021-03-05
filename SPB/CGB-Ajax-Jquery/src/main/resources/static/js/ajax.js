//定义ajax的Get请求函数
function doAjaxGet(url,params,callback){
	//1.创建ajax异步请求对象XmlHttpRequest（这也是ajax技术应用的入口对象）
			var xhr = new XMLHttpRequest();
			//2.设置请求，响应过程的状态监听（通过回调函数处理状态的变化）
			xhr.onreadystatechange=function(){//callback(回调函数）
				//基于xhr对象获取的通讯状态，对响应数据进行处理
				//4表示通讯结束,200表示服务端响应ok
					if(xhr.readyState==4&&xhr.status==200){//500表示服务端出错了
						//服务端响应的结果
						callback(xhr.responseText);
					}
			}
			//3.创建或打开与服务端的链接（设置异步或同步）
			xhr.open("GET",url+"?"+params,true);//true表示异步
			//4.发送异步请求
			xhr.send(null);//Get请求，send方法不传内容
		}
		//post方法
function doAjaxPost(url, params, callback) {
			//1.创建ajax异步请求对象XmlHttpRequest（这也是ajax技术应用的入口对象）
			var xhr = new XMLHttpRequest();
			//2.设置请求，响应过程的状态监听（通过回调函数处理状态变化）
			xhr.onreadystatechange = function() {//callback(回调函数)
				//基于xhr对象获取的通讯状态，对响应数据进行处理
				//4表示通讯结束
				//200表示服务端响应ok
				if (xhr.readyState == 4 && xhr.status == 200) {//500表示服务端出错了
					//服务端响应的结果会传递给XHR对象，我们可以借助responseText获取响应结果
					callback(xhr.responseText);
				}
			};
			//3.创建与服务端的连接
			xhr.open("POST", url, true);//true表示异步
			//post请求必须要设置次请求头
			xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
			//4.发送异步post请求，参数写到send方法中
			xhr.send(params); 
			//5.对响应结果进行处理(在回调函数中处理)。
		}