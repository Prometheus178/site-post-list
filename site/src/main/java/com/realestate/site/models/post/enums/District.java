package com.realestate.site.models.post.enums;

public enum  District {

    NONE("-"),
    KVARTAL103("103 квартал"),
    KVARTAL16("16 квартал"),
    KVARTAL17("17 квартал"),
    MKRN202AND203("202 и 203 мкрн"),
    SHKOLA2("школа №2"),
    SHKOLA31("школа №31"),
    AVIAGRUPPA("Авиагруппа"),
    AVIAPORT("Авиапорт"),
    AVTOVOKSAL("Автовокзал"),
    AVTODOROJNAYA("Автодорожная"),
    APELSIN("Апельсин"),
    BELOE_OSERO("Белое озеро"),
    BORISOVKA2("Борисовка - 2"),
    VAVILON("Вавилон"),
    viluiskiiTract("Вилюйский тракт"),
    GIMEIN("Гимеин"),
    glaznayaBolnica("Глазная больница"),
    GRES("ГРЭС"),
    DARKYLAH("Даркылах"),
    DOMBYTA("Дом быта"),
    drugiePrigorody("Другие пригороды"),
    drugieRaiony("Другие районы"),
    DSK("Дск"),
    DSR("Дср"),
    JATAI("Жатай"),
    ZALOG("Залог"),
    KANGALASSY("Кангалассы"),
    KYRZAVOD("Кирзавод"),
    krestyanskiiRynok("Крестьянский рынок"),
    krytyiRynok("Крытый рынок"),
    MAGAN("Маган"),
    maganskiiTrakt("Маганский тракт"),
    MANCHAARY("Манчаары"),
    MARHA("Марха"),
    namskiiTrakt("Намский тракт"),
    namcyrskiiTrakt("Намцирский тракт"),
    oblastnayaBolnica("Областная больница"),
    ploshadPobedy("Площадь победы"),
    pokrovskiiTrakt("Покровский тракт"),
    poselokGazovikov("Поселок газовиков"),
    poselokGeologov("Поселок геологов"),
    PRIGORODYI("Пригородный"),
    PTICEFABRICA("Птицефабрика"),
    rabochiiGorodokVodokanal("Рабочий городок водоканала"),
    RadioCentr("Радиоцентр"),
    rynokStolichnyi("Рынок Столичный"),
    SAISARY("Сайсаары"),
    SAHACIRK("Сахацирк"),
    sergelyahskoeShosse("Сергеляхское шоссе"),
    staryiGorod("Старый город"),
    studGorodok("Студ.городок"),
    TABAGA("Табага"),
    tulaginoKildyamci("Тулагино-Кильдямцы"),
    ULUS("Улус"),
    HATASSY("Хатассы"),
    hatynUryahskoeShosse("Хатын-Юряхское шоссе"),
    centrPlDrujby("Площадь дружбы"),
    centrPlComsomolskaya("Комсомольская площадь"),
    centrPlLenina("Площадь Ленина"),
    centrPlOrdjonikidze("Площадь Орджоникидзе"),
    YAGITI("ЯГИТИ"),
    YAGSHA("ЯГСХА"),
    YAKSMK("ЯКСМК");

    private String value;
    District(String val) {
        this.value = val;
    }

    public String getValue() {
        return value;
    }
}
