function toggleNum2(){
    const num2 = document.getElementById("num2");
    const operation = document.getElementById("operation").value;
    if (operation === 'square' ){
        num2.style.display = "none";
        num2.required = false;
        num2.value = "";
    } else {
        num2.style.display = "block";
        num2.required = true;
    }
}
window.onload = function() {
    const operation = document.getElementById("operation");
    operation.addEventListener("change", toggleNum2);
    toggleNum2(); // Initial call to set the correct state on page load
}
