function hide(){
    var earrings = document.getElementById('numberOfRoomsSearch');
    earrings.style.display = 'none';
}

function show(){
    var earrings = document.getElementById('numberOfRoomsSearch');
    earrings.style.display = 'inline-block';
}

function apartmentSelectHandler(select){
    if(select.value == 'APARTMENT'){
        show();
    }else{
        hide();
    }}

