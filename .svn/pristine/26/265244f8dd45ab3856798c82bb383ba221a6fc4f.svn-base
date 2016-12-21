/* ----------------------------------------------------------------------
 * Copyright (c) 2011 by RMSI.
 * All Rights Reserved
 *
 * Permission to use this program and its related files is at the
 * discretion of RMSI Pvt Ltd.
 *
 * The licensee of RMSI Software agrees that:
 *    - Redistribution in whole or in part is not permitted.
 *    - Modification of source is not permitted.
 *    - Use of the source in whole or in part outside of RMSI is not
 *      permitted.
 *
 * THIS SOFTWARE IS PROVIDED ''AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL RMSI OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 * ----------------------------------------------------------------------
 */

var publicuserName='';
var savePublicUserData= function () {
	
	jQuery.ajax({
        type: "POST",              
        url: "publicuser/register",
        data: jQuery("#publicUserForm").serialize(),
        success: function (data) {
        	if(data==1){
        		//alert('User '+ publicuserName+' has been registered successfully in SNPA RoW Management System.','Register');
        		//document.location.href = "login";
        		jAlert('User '+ publicuserName+' has been registered successfully in SNPA RoW Management System', 'Register', function () {
                    document.location.href = "login";
                 });

        	}
        	else if(data==2){
        		jAlert('Please try again','Register');
              	 //document.location.href = "login";
           	}
        	else if(data==3){
        		jAlert('User already exists','Register');
             	 //document.location.href = "login";
          	}
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
        	jAlert('Please try again ','Register');
        	 //document.location.href = "login";
        }
    });
	
}



function registerUsers(){
	if(validate_form()){
		savePublicUserData();
	}
}

function validate_form ()
{
	var valid = true;
	var msg;
	publicuserName=$("#name").val();
    if ( $.trim($("#name").val()) == "" )
    {
        valid = false;
		$("#errName").show();
		$("#errName").text('Please enter Name');
    }
	else{
		$("#errName").hide();
	}
	
	if ( $.trim($("#password").val()) == "" )
    {
        $("#errPassword").show();
		$("#errPassword").text('Please enter Password');
        valid = false;
    }
	else{
		$("#errPassword").hide();
	}
	if ( $.trim($("#confirmPassword").val()) == "" )
    {
       	$("#errConfirmPassword").show();
		$("#errConfirmPassword").text('Please re-enter Password.');
        valid = false;
    }
	else{
	$("#errConfirmPassword").hide();
	}
	if ( $.trim($("#password").val()) != $.trim($("#confirmPassword").val()))
    {
        //alert ( "Password and Confirm Password should be same." );
		$("#errConfirmPassword").show();
		$("#errConfirmPassword").text('Confirm Password should be same as Password');
        valid = false;
		//return valid;
    }
	else{
	$("#errConfirmPassword").hide();
	}
	if ( $.trim($("#phone").val()) == "" )
    {
       // alert ( "Please enter Phone number." );
		$("#errPhone").show();
		$("#errPhone").text('Please enter Phone no');
        valid = false;
		//return valid;
    }else{
			if(!phoneNumberValidator($.trim($("#phone").val()))){
	   // alert ( "Please enter a valid phone no." );
		$("#errPhone").show();
		$("#errPhone").text('Please enter a valid Phone no');
		valid = false;
		//return valid;
	   }
	   else{
	$("#errPhone").hide();
	}
	}
	/*if ( $.trim($("#mobile").val()) == "" )
    {
       // alert ( "Please enter mobile number." );
		$("#errMobile").show();
		$("#errMobile").text('Please enter mobile no');
        valid = false;
		//return valid;
    } else{
			if(!numberValidator($.trim($("#mobile").val()))){
	   // alert ( "Please enter a valid mobile no." );
		$("#errMobile").show();
		$("#errMobile").text('Please enter a valid mobile no');
		valid = false;
		//return valid;
	   }
	   else{
	$("#errMobile").hide();
	}
	}*/
	if ( $.trim($("#email").val()) == "" )
    {
	   //alert ( "Please enter a email" );
	   $("#errEmail").show();
		$("#errEmail").text('Please enter email');
        valid = false;
		//return valid;
    }
	else{
	if(!emailValidator($.trim($("#email").val()))){
	    //alert ( "Please enter a valid Email." );
		$("#errEmail").show();
		$("#errEmail").text('Please enter a valid email id');
		valid = false;
		//return valid;
	   }
	   else{
	$("#errEmail").hide();
	}
	}
	if ($.trim($("#address").val()) == "" )
    {
        //alert ( "Please enter your address." );
		$("#errAddress").show();
		$("#errAddress").text('Please enter address');
        valid = false;
		//return valid;
    }
	else{
	$("#errAddress").hide();
	}
	if ( $.trim($("#langpref").val()) == "" )
    {
        //alert ( "Please select Language Pref." );
		$("#errlang").show();
		$("#errlang").text('Please select Language');
        valid = false;
		//return valid;
    }
	else{
	$("#errlang").hide();
	}
	
   return valid;
}

function emailValidator(val){
	var emailExp = /^[\w\-\.\+]+\@[a-zA-Z0-9\.\-]+\.[a-zA-z0-9]{2,4}$/;
	if(val.match(emailExp)){
		return true;
	}else{
		return false;
	}
}


function phoneNumberValidator(val){
	var  numExp = /\s\d/g;
	if(val.match(numExp)){
		return true;
	}else{
		return false;
	}
}

function numberValidator(val){
	var  numExp = /^-?(?:\d+|\d{1,3}(?:,\d{3})+)(?:\.\d+)?$/;
	if(val.match(numExp)){
		return true;
	}else{
		return false;
	}
}


function numberValidator(val){
	var  numExp = /^-?(?:\d+|\d{1,3}(?:,\d{3})+)(?:\.\d+)?$/;
	if(val.match(numExp)){
		return true;
	}else{
		return false;
	}
}


function lengthRestriction(value, min, max){
	
	if(value.length >= min && value.length <= max){
		return true;
	}else{
		//alert("Please enter between " +min+ " and " +max+ " characters");
		return false;
	}
}

function restfields(){
$("#name").val()="";
$("#password").val()="";
$("#confirmPassword").val()="";
$("#address").val()="";
$("#email").val()="";
$("#phone").val()="";
$("#mobile").val()="";
}
