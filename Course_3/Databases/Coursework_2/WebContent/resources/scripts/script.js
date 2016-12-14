/**
 * Created by sitora on 06.12.16.
 */
var phone, pass, name;
function phonenumber(inputtxt) {
    var phoneno = /^\d{11}$/;
    if ((inputtxt.value.match(phoneno))) {
        validB(true);
        phone = true;
        return true;
    }
    else {
        validB(false);
        phone = false;
        return false;
    }
}
function checkPass(inputtxt) {
    var phoneno = /^\d{10}$/;
    if ((inputtxt.value.match(phoneno))) {
        validB(true);
        pass = true;
        return true;
    }
    else {
        validB(false);
        pass = false;
        return false;
    }
}
function checkName(inputtxt) {
    var phoneno = /^[a-z ,.'-]+$/i;
    if ((inputtxt.value.match(phoneno))) {
        validB(true);
        name = true;
        return true;
    }
    else {
        validB(false);
        name = false;
        return false;
    }
}
function validB(isValid) {
    if (phone && pass && name) {
        document.getElementById("sButton").disabled = false;
    }
    else {
        document.getElementById("sButton").disabled = true;

    }
}

function validBtn() {
    if (phone && pass && name) {
        document.getElementById("sButton").disabled = true;
    }
}