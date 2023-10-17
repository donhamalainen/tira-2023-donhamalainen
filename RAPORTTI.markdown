# Raportit tehtävistä

Kirjaa tähän tiedostoon **jokaiseen** tehtävään liittyvät omat raporttisi ja analyysisi. Muista että raportti on myös kurssilla **arvosteltava tehtävä**.

Voit sisällyttää raporttiin tekstimuotoisia taulukoita (tasaukset välilyönnein):

```
n     Fill     Search   Total
500   7        700      707
1000  9        288      297
```

Ja näihin liittyviä kuvatiedostoja:

![Esimerkkikuva](report-sample-image.png)

Nämä näkyvät sitten VS Coden Preview -näkymässä (tai oman repositorysi webbisivulla) oikein muotoiltuna. Käytä tässä dokumentissa olevia muotoiluja esimerkkinä kun kirjoitat raporttiasi. 

Huomaa että jos laitat kuvatiedostot vaikka omaan alihakemistoonsa, Markdown -muotoilussa on oltava suhteellinen polku tiedostoon, esimerkiksi `images/report-sample-image.png`. **Älä** käytä absoluuttisia polkuja `C:\Users\tippaleipa\kurssit\TIRA\kuva.png`, koska nämä eivät tietenkään toimi opettajan koneella. Ei kannata laittaa linkkiä etärepoosikaan, vaan nimenomaan paikalliseen tiedostoon.

Voit myös sisällyttää *lyhyitä* koodinpätkiä vaikkapa Java -formaatilla:

```Java
	@Override
	public int hashCode() {
		// Oma nerokas hajautufunktioni!
	}
```
Tarvittaessa käytä myös paremmin muotoiltuja taulukoita:

| n	| Fill	| Search	| Total |
|-----|--------|--------|-------|
| 500	 | 7	| 700	| 707 |
| 1000 |	9	| 288	| 297 | 

Alaluvut jokaisen tehtävän raportille löydät alta.


## 01-TASK

Kävin ensimmäisessä tehtävässä läpi insertion sort algorytmiä. Algorytmin rakentaminen ei ollut omasta puolestani haastavaa eikä edellyttänyt paljoakaan aikaa sen kokonaisuuden ymmärtämiseen. Haastavin asia oli sisäistää tai ymmärtää koko projektin toiminnallisuus. 

- Insetion Sort algorytmi on yleensä O(n^2) eli neliöllinen (quadratic / kvadraattinen), mutta voi myös olla lineaarinen O(n) riippuen JSON tai datan esitysjärjestyksestä.
- Reverse - algorytmi eli tässä tapauksessa metodi joka kääntää taulukon ympäri on aikakompleksisuutena O(n) eli lineaarinen.

Raportin kysmyksessä oli "Jos taulukko on jo valmiiksi järjestyksessä nousevaan järjestykseen, ja se aiotaan lajitella laskevaan järjestykseen, kannattaako taulukko lajitella vai kääntää sen järjestys? Miksi, perustele?"

Tässä tapauksessa Reverse metodi on suositeltavampaa koska sen aikakompleksisuus on lineaari O(n) kun taas insertion sort on O(n) tai O(n^2) riippuen taulukon koosta.

## 02-TASK

### Graaffi analyysi
Tehtävässä 2, askeleessa 3 tehdyssä tehtävässä sain tarkasteltavaksi arvoja, jotka ovat riippuvaisia algorytmistä insertionSort ja myös oman koneeni suoritustehosta. X-akselilla on datan kasvu (n). Huomamme että "Fill" tekee jonkinlaisen pudotuksen alussa, mutta on muutoin lineaarinen kun "Search" on taas lähes eksonentiaalinen. Kuvaajassa nähdään "Fill" ja "Search" risteyskohta, sekä pieniä "droppeja" graafissa. Uskon että nämä "dropit" graaffissa johtuvat tietorakenteen järjestyksestä jolloin hakuun voi mennä vähemmän aikaa. Risteyskohdasta en ole täysin varma.

![Fill & Search Chart](/student_images/task2_step3_chartImage_DonH.png)

![Data](/student_images/task2_step3_dataImage_DonH.png)

### Tehtävä raportti
Lineaarista hakualgorytmiä kutsutaan lineaariseksi, koska se käy tietorakenteen (esim. taulukon tai listan) läpi elementti kerrallaan alusta loppuun asti tai kunnes etsittävä kohde on löydetty. Lineaarisen haun aikakompleksisuusluokka big-O -notaatiolla esiteltynä on O(n), missä n on tietorakenteen pituus (elementtien lukumäärä). Tämä tarkoittaa että algorytmin suoritusaika kasvaa suoraan verrannollisesti tietorakenteen pituuteen (n). Luomamme insertionSort algorytmi ei ole lineaarinen vaan kvadraattinen O(n^2) riippuen tietorakenteen järjestyksestä ja pituudesta. SimpleContaineriin tehdyt muutokset kuten E get() jossa on yksinkertainen for-silmukka on lineaarinen.


## 03-TASK

Tehtävän tekeminen tarjosi merkittävän mahdollisuuden oppia lisää binäärisestä hakualgorytmistä. Opin että binäärinenhaku on tehokas tapa löytää tietty elementti järjestetystä tietorakenteesta, kuten taulukosta tai listasta. Sen periaate perustuu jatkuvaan puolittuvaan hakuun, jossa keskipiste määritellään ja vertaillaan haettavaan arvoon eli avainarvoon.

* Mikä oli haasteellista?
	* Iteratiivisen binäärihaun toteutus oli omastamielestäni yksinkertainen, kiitos visuaalisen esimerkin. Kuitenkin vaikeutta tuotti
	rekurssiivinen haku tuotti erityisiä haasteita pino ylivuodon takia. 

Toteutettu hakualgorytmejä kutsutaan lineaariseksi, koska ne käyvät tietorakennetta läpi yksikerrallaan. Tämä tarkoittaa että sen aikakompleksisuus on neliöllinen O(n^2) ja suoritusaika on suoraan verrannollinen tietorakenteen kokoon. Toteuttamani binäärihakualgorytmi on aikakompleksisuudeltaan O(log n), mikä tarkoittaa että sen suoritusaika kasvaa hitaasti, kun tietorakenteen koko kasvaa. Tämä tekee siitä erityisen tehokkaan tietorakenteen. 

### Graaffi analyysi

Graaffissa olevat sininen (Series1 = Fill) ja oranssi (Series2 = Search) viiva kuvaavat kuinka binäärihakualgorytmi suoritutuu tehtävästä. Huomataan erityisen hyvin kuinka oranssi viiva tasaisena vaikka Fill kasvaa. Tästä voidaan tehdä johtopäätös kuinka tehokas binäärihakualgorytmi oikeasti on isommillakin tietorakenteilla. Se pystyy löytämään halutun elementin suuremmastakin tietorakenteesta

![Fill & Search Chart](/student_images/task3_chartImage_DonH.png)

## 04-TASK

Kirjaa raporttiisi RAPORTTI.markdown mitä opit tehtävän tekemisestä, mikä oli vaikeaa, mikä helppoa, jne.
Analysoi erityisesti sitä, onko toteutuksesi sellainen että se vastaa tehtävän alussa esiteltyjä aikakompleksisuusvaatimuksia. Perustele miksi.
Miten tarkistin toimii jos lainausmerkit tekstissä ovat väärin (niitä puuttuu tai on liikaa)? Analysoi algoritmin oikeellisuutta tässä tilanteessa.
Mikä tahansa metodi jossa on silmukka, ei voi olla O(1) -- onko sinulla silmukoita metodeissa joissa vaatimus oli O(1)? Tai kutsutko tällaisesta metodista jotain toista metodia jonka O on muuta kuin O(1)? Jos näin on, aikakompleksisuusvaatimus ei täyty.

### Tehtävä raportti

Tehtävässä toteutin StackImplementation tiedoston ja ParenthesisChecker tiedostossa olevan metodin checkParentheses(). 

* Haasteita:
	- Koin itse tehtävän toisen osan haasteelliseksi, koska en oikein ymmärtänyt tehtävänantoa kunnolla, mutta muutamien tuntien jälkeen idea alkoi selventyä. Muutoin tehtävä oli aika simppeli. 
	- Toinen haaste joka ilmeni StackImplementation oli aluksi se että mitä metodeilta halutaan. Kieltämättä myös omaa tyhmyyttäni että en osannut heti liittää näitä termistoja, mutta muutoin tehtävä oli helppo. En oikein kyllä tiedä miten näitä aikakompleksisuuksia testaisin, mutta uskon että olen ottanut ne huomioon parhaani mukaan.

Uskon onnistuneeni tehtävänannossa mainittujen aikakompleksisuuksien osalta, vaikkakin niiden tarkistusta en oikein osannut toteuttaa tässä tilanteessa. Otin aikakompleksisuuden huomioon esim siten että en hyödyntänyt capacity(), size() tai muissa "laskennallisissa" metodeissa for-silmukkaa tai muitakaan silmukallisia lauseita jotka pitkittäisivät aikakompleksisuutta huomattavasti. Nyt olen varma että aikakompleksisuus on yksi:yhteen. 

Toisen tehtävän tarkistus (")-merkeille aktivoi boolean omaavan muuttujan joka toimii "tarkistajana" ohjelmassa. Ohitan sen alla olevat koodit seuraavaan iteraatioon asti (continue;) komennon avulla. Kuitenkin, jos muuttuja saa arvoksi (")-merkin niin muuttaa se boolean arvon true arvoksi jolloin if()- ehtolause päästää lukijan continue; lauseeseen. 

En ole toteuttanut silmukallisia lauseita ohjelmassa, jossa aikakompleksisuus vaatimus on O(1). 

## 05-TASK

Kirjaa raporttiisi RAPORTTI.markdown mitä opit tehtävän tekemisestä, mikä oli vaikeaa, mikä helppoa, jne.
Jos toteutit tässä molemmat tietorakenteet, mainitse siitä raportissasi, jotta opettajat huomaavat testata ne ja antaa tehtävästä lisäpisteet!
Vaikket olisi toteuttanutkaan molempia vaihtoehtoisia toteutuksia jonosta (taulukko ja linkitetty lista), pohdi miten ne eroavat toisistaan:

Missä asioissa linkitetty lista on parempi kuin taulukkopohjainen toteutus, muistin käytön (muistikompleksisuus) ja aikatehokkuuden (aikakompleksisuus) suhteen?
Missä asioissa taulukkopohjainen toteutus päihittää linkitetyn listan, muistin käytön ja aikatehokkuuden suhteen?

Analysoi erityisesti sitä, onko toteutuksesi oikeasti sellainen että se vastaa tehtävän alussa esiteltyjä aikakompleksisuusvaatimuksia.

### Tehtävä raportti

Tehtävässä toteutin jono-tietorakenteen, jossa pääsin syventymään tarkemmin sen periaatteisiin. Opin "karusellimäisen" ajattelutavan tietorakenteen lukemisesta. Toteuttamani jono-tietorakenne hyödyntää (tail) ja (head) muuttujia jotka kuvaavat tietorakenteessa olevia kohtia. Tail muuttuja lisää enqueue() metodin avulla tietorakenteeseen alkion, ja vaihtaa paikkaa seuraavaan tietorakenteen kohtaan. Head taas poistaa dequeue() metodin avulla tietorakenteesta alkion. Nämä kaksi yhdessä toimivat karusellimäisesti eli jos tietorakenne ei ole täynnä niin tail siirtyy vasemmalta katsottuna seuraavaan tyhjään indexi kohtaan.

Metodit enqueue() ja dequeue() ovat big-O -notaatiolla O(1), koska ne eivät sisällä minkäänlaisia silmukoita. Ohjelma sisältää silmukan ainoastaan reallakointi funktiossa reallocate().

Ero linkitetyssä ja taulukkopojaisessa jono-tietorakenteessa on muistin käyttö. Linkitetyssä muistia ei varata enempää mitä on tarvetta varata, kun taas taulukkopohjaisessa annetaan, jonkinlainen aloitus muistiarvo kuten tässä DEFAULT_STACK_SIZE = 10. 
Reallakoidessa tämä tuplataan.

Olen yrittänyt toteuttaa tässä tehtävässä linkitetyn jono-tietorakenteen ja se löytyy nimellä LinkedListQueue.java /student/ kansiosta. Tämä rakennelma ei kuitenkaan toimi.

## 06-TASK

## 07-TASK

## 08-TASK

## 09-TASK