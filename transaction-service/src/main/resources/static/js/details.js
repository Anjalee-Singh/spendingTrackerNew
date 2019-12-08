$(function () {
        $('.form-control').on('change', function () {  
        	 var count = 0;
            var SelectList = $('.form-control');
            for (var i = 0; i < SelectList.length ; i++) {
                if (SelectList[i].value != "0") {
                	count ++; 
                }
                
            }
            
                if(count == SelectList.length) {
                  $('#confirmButton').attr("disabled", false);
                  $('#confirmButton').removeClass('disabledInput');
                  $('#confirmButton').addClass('login100-form-btn');
                }
   
        }); 
    });