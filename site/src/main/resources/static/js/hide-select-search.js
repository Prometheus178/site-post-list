function hide() {
    var numberOfRoom = document.getElementById('numberOfRoomsSearch');
    numberOfRoom.style.display = 'none';
}

function show() {
    var numberOfRoom = document.getElementById('numberOfRoomsSearch');
    numberOfRoom.style.display = 'inline-block';
}

function apartmentSelectHandler(select) {
    if (select.value == 'APARTMENT') {
        show();
    } else {
        hide();
    }
}

function hideCommercial() {
    var commercial = document.getElementById('commercialSearch');
    commercial.style.display = 'none';
}

function showCommercial() {
    var commercial = document.getElementById('commercialSearch');
    commercial.style.display = 'inline-block';
}

function livingSelected(select) {
    if (select.value == 'GARAGE' ||'ROOM' ||'HOUSE' ||'DACHA'||'STEAD'||'APARTMENT') {
        hideCommercial();
    } else {
        showCommercial();
    }
}

function hideLiving() {
    var living = document.getElementById('livingSearch');
    living.style.display = 'none';
}

function showLiving() {
    var living = document.getElementById('livingSearch');
    living.style.display = 'inline-block';
}

function commercialSelected(select) {
    if (select.value == 'OFFICE' ||'BUILDING' ||'TRADING_Area' ||'FREE_APOINTMENT_ROOM'||'PRODUCTION'||'STOCK'||'READY_BUSINESS'||'COMMERCIAL_STEAD') {
        hideLiving();
    } else {
        showLiving();
    }
}


