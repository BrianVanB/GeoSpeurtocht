# GeoSpeurtocht

### Een minecraft plugin gebruikt voor de minecraft speurtocht op het GeoFort.

Spelers moeten vanaf een startpunt op zoek gaan naar bepaalde locaties in de minecraft wereld (deze locaties moet je zelf maken, de plugin doet dit niet). Zij moeten dit binnen een bepaalde tijd zien te vinden.
Het startpunt en de tijd zijn in te stellen. De spelers staan bevroren op het startpunt todat de speurtocht start. Na de start worden de  spelers vrijgelaten. Zodra de tijd om is worden de spelers automatisch weer bevroren en teruggezet naar het startpunt.

------------------

## Permissies

* Begeleider: Standaard voor op's, heeft controle over de spelers
* Speler: Voor de spelers

------------------

## Commando's

Commando | Beschrijving | Permissie
---------|--------------|-------------
/setstart | Markeert de locatie waar je staat als het startpunt | Begeleider
/startpunt | Teleporteert naar het startpunt | Speler
/startall <tijd> | Voorbeeld: /startall 10, Dit laat de spelers 10 minuten vrij rondlopen. | Begeleider
/stopall | Dit stopt de timer en zet alle spelers bevroren terug op het startpunt. | Begeleider
/stoptimers | Dit stopt de timer zonder alle spelers terug te zetten | Begeleider
/freezeall | Bevriest alle spelers op hun plek | Begeleider
/unfreezeall | Laat alle bevroren spelers weer vrij | Begeleider
/freeze <speler> | Bevriest de gegeven speler | Begeleider
/unfreeze <speler> | Laat de gegeven speler weer vrij | Begeleider
/tpall | Teleporteert alle spelers naar jouw locatie | Begeleider
/broadcast | Stuur een bericht naar alle spelers op de server | Begeleider

-----------------

## Benodigdheden

Er zijn geen verplichte benodigdheden, deze plugin kan helemaal alleen werken.

Er is ondersteuning voor Muliverse. Met multiverse wordt de wereld waarin het startpunt zich bevind ook opgeslagen.

