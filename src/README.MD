Podobně jako v u prvního projektu budeme pracovat s daňovými sazbami, ale tentokrát nebudeme data získávat přímo ze souboru, ale zde: https://euvatrates.com/rates.json a nepůjde o parsování obyčejného textového souboru, ale data budou ve formátu JSON.

Úkolem bude data načíst, rozparsovat, uložit, vyhledat 3 země s nejvyššími sazbami a 3 země s nejnižšími sazbami a vypsat je.

Postupně:

Zavolat API pomocí HTTP
Načíst JSON soubor
Naparsovat JSON soubor do objektu
Implementovat vyhledávací logiku
Vypsat hodnoty pomocí interaktivní příkazové řádky
Umožnit zapsat výsledek do souboru
BONUS1: Následně pak také implementovat vyhledávání daňových sazeb podle zkratek zemí, které bude uživatel zadávat do konzole.

BONUS2: Vytvořte vlastní HTTP API, které vystaví danou funkcionalitu přes webový server (jak jsme si ukázali v lekci 12)