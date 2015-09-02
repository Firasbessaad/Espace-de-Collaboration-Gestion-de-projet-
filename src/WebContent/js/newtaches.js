$(document).ready(function() {
    var max_fields      = 10; //maximum input boxes allowed
    var wrapper         = $(".input_fields_taches"); //Fields wrapper
    var add_button      = $(".ajt"); //Add button ID
   
    var x = 0; //initlal text box count
    $(add_button).click(function(e){ //on add input button click
        e.preventDefault();
        if(x < max_fields){ //max input box allowed
            x++; //text box increment
            $(wrapper).append('<div class="input_fields_wrap"><ul><div><input type="text" name="tache1" class="login-control m-b-10" placeholder="ecrire la tache ici ..."></div><button class="ajt">Ajouter une autre sous-tache</button></ul> </div>'); //add input box
        }
    });
   
    $(wrapper).on("click",".remove_field", function(e){ //user click on remove text
        e.preventDefault(); $(this).parent('div').remove(); x--;
    })
});

