function hide(){
    var numberOfRoom = document.getElementById('numberOfRoomsSearch');
    numberOfRoom.style.display = 'none';
}

function show(){
    var numberOfRoom = document.getElementById('numberOfRoomsSearch');
    numberOfRoom.style.display = 'inline-block';
}

function apartmentSelectHandler(select){
    if(select.value == 'APARTMENT'){
        show();
    }else{
        hide();
    }}


