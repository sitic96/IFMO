/**
 * Created by sitora on 06.12.16.
 */
function phonenumber(inputtxt) {
    var phoneno = /^\d{11}$/;
    if ((inputtxt.value.match(phoneno))) {
        document.getElementById("sButton").disabled = false;
        return true;
    }
    else {
        document.getElementById("sButton").disabled = true;
        return false;
    }
}


function checkPass(inputtxt) {
    var phoneno = /^\d{10}$/;
    if ((inputtxt.value.match(phoneno))) {
        document.getElementById("sButton").disabled = false;
        return true;
    }
    else {
        document.getElementById("sButton").disabled = true;
        return false;
    }
}
function checkName(inputtxt) {
    var phoneno = /^[a-z ,.'-]+$/i;
    if ((inputtxt.value.match(phoneno))) {
        document.getElementById("sButton").disabled = false;
        return true;
    }
    else {
        document.getElementById("sButton").disabled = true;
        return false;
    }
}