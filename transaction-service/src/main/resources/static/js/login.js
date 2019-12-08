$(document).ready(function(){
	

      $("#login").click(function(e){

    	  var phoneNumber= $("#phoneNumber").val();
          e.preventDefault();
        $.ajax({type: "POST",
                url: "/authenticate",
                data: { username: $("#phoneNumber").val(), password: $("#password").val() },
                success:function(data, textStatus, xhr){
                	sessionStorage.setItem('token',data.token);
                	 $.ajax({type: "POST",
                         url: "/checkUser",
                         dataType:'html',
                         headers: {
                        	 "Authorization": 'Bearer ' +sessionStorage.getItem('token')
                         },
                         beforeSend: function (xhr){ 
                             xhr.setRequestHeader('Authorization','Bearer ' +sessionStorage.getItem('token')); 
                         },
                         data: data.userDetails,
                         success:function(data, textStatus, xhr){
                        	 var json,input;
                        	 json = JSON.stringify(data);
                        	 $('input[name="phoneNumber"]').val(phoneNumber);
                             $("#response_file").submit();
                             },
                        error: function (data, textStatus, xhr) {
                             alert(data.responseText);
                            }
                       });
                    },
               error: function (data, textStatus, xhr) {
                    alert(data.responseText);
                   }
              });
      });
 });