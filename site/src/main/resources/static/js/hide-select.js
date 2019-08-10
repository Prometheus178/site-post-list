function hideRentTypePost() {
    var rentType = document.getElementById('rentTypePost');
    rentType.style.display = 'none';
}

function showRentTypePost() {
    var rentType = document.getElementById('rentTypePost');
    rentType.style.display = 'inline-block';
}
function rentTypeSelectHandlerPost(select) {
    if (select.value == 'RENT') {
        showRentTypePost();
    } else {
        hideRentTypePost();
    }
}

function showLivingPost() {
    var living = document.getElementById('livingPost');
    living.style.display = 'inline-block';
    var numberOfRooms = document.getElementById('numberOfRoomsPost');
    numberOfRooms.style.display = 'inline-block';
    var buildingType = document.getElementById('buildingTypePost');
    buildingType.style.display = 'inline-block';
    var repairs = document.getElementById('repairsPost');
    repairs.style.display = 'inline-block';
    var additionLivingPost = document.getElementById('additionLivingPost');
    additionLivingPost.style.display = 'inline-block';
}

function hideLivingPost() {
    var living = document.getElementById('livingPost');
    living.style.display = 'none';
    var numberOfRooms = document.getElementById('numberOfRoomsPost');
    numberOfRooms.style.display = 'none';
    var buildingType = document.getElementById('buildingTypePost');
    buildingType.style.display = 'none';
    var repairs = document.getElementById('repairsPost');
    repairs.style.display = 'none';
    var additionLivingPost = document.getElementById('additionLivingPost');
    additionLivingPost.style.display = 'none';
}

function realEstateLivingTypeSelectHandlerPost(select) {
    if (select.value == 'LIVING'){
        showLivingPost();
    }else {
        hideLivingPost();
    }
}

function hideCommercialPost() {
    var commercial = document.getElementById('commercialPost');
    commercial.style.display = 'none';
}

function showCommercialPost() {
    var commercial = document.getElementById('commercialPost');
    commercial.style.display = 'inline-block';
}
function realEstateCommercialTypeSelectHandlerPost(select) {
    if (select.value == 'COMMERCIAL'){
        showCommercialPost();
    }else {
        hideCommercialPost();
    }
}