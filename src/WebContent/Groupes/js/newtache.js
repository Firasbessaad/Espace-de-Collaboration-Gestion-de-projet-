$(document).ready(function() {
    var max_fields      = 10; //maximum input boxes allowed
    var wrapper         = $(".input_fields_wrap"); //Fields wrapper
    var add_button      = $(".ajt"); //Add button ID
   
    var x = 1; //initlal text box count
    $(add_button).click(function(e){ //on add input button click
        e.preventDefault();
        if(x < max_fields){ //max input box allowed
            x++; //text box increment
            $(wrapper).append('<div><label>Titre de la soustache</label><input type="text" name="tache'+x+'" class="login-control m-b-10" placeholder="ecrire le titre de la tache ici.."/><label>Date de debut de la soustache</label><input type="text" class="input-sm form-control mask-date" placeholder="01/01/2015" maxlength="10" autocomplete="on" name="datedebut_tache'+x+'"><label>Date de fin de soustache</label><input type="text" class="input-sm form-control mask-date" placeholder="01/02/2015" maxlength="10" autocomplete="on" name="datefin_tache'+x+'"><a href="#" class="remove_field">Remove</a></div></li>'); //add input box
        }
    });
   
    $(wrapper).on("click",".remove_field", function(e){ //user click on remove text
        e.preventDefault(); $(this).parent('div').remove(); x--;
    })
});
