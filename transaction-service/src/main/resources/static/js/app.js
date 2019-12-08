function addEvent() {
	var row;
	var tableData = document.getElementById('t_draggable2');
	var numberOfRows = tableData.rows.length;
	for (var i = 1; i < numberOfRows; i += 1) {
		if (i > 1) {
			 row = tableData.rows[i - 1].innerHTML + tableData.rows[i].innerHTML;
		}

	}
	
	alert(JSON.stringify(row));
	 $.ajax({
	        type: "POST",
	        contentType: "application/json",
	        url: "/submitUserDetails",
	        data: JSON.stringify(row),
	        dataType: 'json',
	        cache: false,
	        timeout: 600000,
	        success: function (data) {

	           

	        },
	        error: function (e) {

	           

	        }
	    });
}



$(document).ready(
	    function(){
	        $('input:file').change(
	            function(){
	                if ($(this).val()) {
	                    $('input:submit').attr('disabled',false);
	                    $('input:submit').removeClass('disabledInput');
	                    $('input:submit').addClass('login100-form-btn');
	                } 
	            }
	            );
	    });

