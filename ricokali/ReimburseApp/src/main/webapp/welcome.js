/**
 * 
 */
function onclickEvent()
{
    alert('Submitting!!!');
}

function onmouseoverempEvent()
{
    document.getElementById("empLoginButton").style.backgroundColor = "yellow";
    document.getElementById("empWelcomeButton").style.backgroundColor = "red";
}

function onmouseoutempEvent()
{
    document.getElementById("empLoginButton").style.backgroundColor = "red";
    document.getElementById("empWelcomeButton").style.backgroundColor = "yellow";
}

function onmouseovermanEvent()
{
    document.getElementById("manLoginButton").style.backgroundColor = "yellow";
    document.getElementById("manWelcomeButton").style.backgroundColor = "yellow";
}

function onmouseoutmanEvent()
{
    document.getElementById("manLoginButton").style.backgroundColor = "green";
    document.getElementById("manWelcomeButton").style.backgroundColor = "green";

}

function onmouseoverwelcomeEvent()
{
    
   /* document.getElementById("manWelcomeButton").style.backgroundColor = "blue";
    document.getElementById("empWelcomeButton").style.backgroundColor = "yellow"; */
    document.getElementsByClassName("buttonEmp").style.backgroundColor = "yellow";
    document.getElementsByClassName("buttonMan").style.backgroundColor = "blue";
}

function onmouseoutwelcomeEvent()
{
    
   /* document.getElementById("manWelcomeButton").style.backgroundColor = "yellow";
    document.getElementById("empWelcomeButton").style.backgroundColor = "blue"; */
    document.getElementsByClassName("buttonEmp").style.backgroundColor = "blue";
    document.getElementsByClassName("buttonMan").style.backgroundColor = "yellow";
}


$(function()
{
    function after_form_submitted(data) 
    {
        if(data.result == 'success')
        {
            $('form#reused_form').hide();
            $('#success_message').show();
            $('#error_message').hide();
        }
        else
        {
            $('#error_message').append('<ul></ul>');

            jQuery.each(data.errors,function(key,val)
            {
                $('#error_message ul').append('<li>'+key+':'+val+'</li>');
            });
            $('#success_message').hide();
            $('#error_message').show();

            //reverse the response on the button
            $('button[type="button"]', $form).each(function()
            {
                $btn = $(this);
                label = $btn.prop('orig_label');
                if(label)
                {
                    $btn.prop('type','submit' ); 
                    $btn.text(label);
                    $btn.prop('orig_label','');
                }
            });
            
        }//else
    }

	$('#reused_form').submit(function(e)
      {
        e.preventDefault();

        $form = $(this);
        //show some response on the button
        $('button[type="submit"]', $form).each(function()
        {
            $btn = $(this);
            $btn.prop('type','button' ); 
            $btn.prop('orig_label',$btn.text());
            $btn.text('Sending ...');
        });
        

                    var formdata = new FormData(this);
            $.ajax({
                type: "POST",
                url: 'handler.php',
                data: formdata,
                success: after_form_submitted,
                dataType: 'json' ,
                processData: false,
                contentType: false,
                cache: false        
            });
        
      });	
});

