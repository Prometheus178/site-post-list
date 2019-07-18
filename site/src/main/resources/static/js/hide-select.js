$(document).ready(function() {
    $('#dealType').change(function() {
        if ($("#dealType :selected").val()!="SELL") {
            $("#rentType").css("display", "inline-block");
        }else {
            $("#rentType").val($("#spisok option:first").val());
            $("#rentType").css("display", "none");
        }
    });

    $('#realEstateType').change(function() {
        if ($("#realEstateType :selected").val()=="LIVING") {
            $("#living").css("display", "inline-block");
            $("#deposit").css("display", "inline-block");
            $("#numberOfRooms").css("display", "inline-block");
            $("#squareOfLiving").css("display", "inline-block");
            $("#squareOfKitchen").css("display", "inline-block");
            $("#floor").css("display", "inline-block");
            $("#repairs").css("display", "inline-block");
            $("#animal").css("display", "inline-block");
            $("#furniture").css("display", "inline-block");
            $("#furnitureInTheKitchen").css("display", "inline-block");
            $("#windowInside").css("display", "inline-block");
            $("#windowOutside").css("display", "inline-block");
            $("#balcony").css("display", "inline-block");
            $("#loggia").css("display", "inline-block");
            $("#fridge").css("display", "inline-block");
            $("#tv").css("display", "inline-block");
            $("#phone").css("display", "inline-block");
            $("#bath").css("display", "inline-block");
            $("#shower").css("display", "inline-block");
            $("#conditioner").css("display", "inline-block");
            $("#internet").css("display", "inline-block");
            $("#separateBathroom").css("display", "inline-block");
            $("#combinedBathroom").css("display", "inline-block");
            $("#lift").css("display", "inline-block");
            $("#ramp").css("display", "inline-block");
        }else {
            $("#living").val($("#spisok option:first").val());
            $("#living").css("display", "none");
            $("#buildingType").css("display", "none");
            $("#deposit").css("display", "none");
            $("#numberOfRooms").css("display", "none");
            $("#squareOfLiving").css("display", "none");
            $("#squareOfKitchen").css("display", "none");
            $("#floor").css("display", "none");
            $("#repairs").css("display", "none");
            $("#animal").css("display", "none");
            $("#furniture").css("display", "none");
            $("#furnitureInTheKitchen").css("display", "none");
            $("#windowInside").css("display", "none");
            $("#windowOutside").css("display", "none");
            $("#balcony").css("display", "none");
            $("#loggia").css("display", "none");
            $("#fridge").css("display", "none");
            $("#tv").css("display", "none");
            $("#phone").css("display", "none");
            $("#bath").css("display", "none");
            $("#shower").css("display", "none");
            $("#conditioner").css("display", "none");
            $("#internet").css("display", "none");
            $("#separateBathroom").css("display", "none");
            $("#combinedBathroom").css("display", "none");
            $("#lift").css("display", "none");
            $("#ramp").css("display", "none");
        }
    });

    $('#realEstateType').change(function() {
        if ($("#realEstateType :selected").val()=="COMMERCIAL") {
            $("#commercial").css("display", "inline-block");
        }else {
            $("#commercial").val($("#spisok option:first").val());
            $("#commercial").css("display", "none");
        }
    });

    // $('#realEstateType').change(function() {
    //     if ($("#realEstateType :selected").val()=="LIVING") {
    //         $("#living").css("display", "inline-block");
    //     }
    //     if ($("#realEstateType :selected").val()=="COMMERCIAL"){
    //         $("#commercial").css("display", "inline-block");
    //     } else {
    //         $("#living").val($("#spisok option:first").val());
    //         $("#living").css("display", "none");
    //         $("#commercial").val($("#spisok option:first").val());
    //         $("#commercial").css("display", "none");
    //     }
    // });

});