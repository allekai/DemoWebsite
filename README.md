# Demo Website with Spring and other fun stuff

On Windows: Clone the project and run from top level folder with

```mvnw clean package && java -jar target\serving-web-content-0.0.1-SNAPSHOT.jar```


ToDo:

(The numbers are references to the input listed below)

- Thymeleaf Templating
	- ~~Dynamic Navbar~~
	- Dynamic Navbar link colorization (current link should be colored)
		- probably needs JS... But do we need this at all? Many Websites don't use it
		- Otherwise: Use Breadcrumbs to show where we are
	- Contacts: Utilize user database for automatic updates to the website
	- Add favicon
	- ~~Add WM Logo [1]~~
		- Name, Age, Mail adress, Phone Number, etc. [4]
- **Proper and secure handling of requests**
- Add cards as links to subpages
	- for groups
		- image of group in scout uniform [2]
		- ~~incorporate scout groups patron animal [6]~~
		- Maybe via mouse-over effect on the tiles? First you see the animal, then the group
	- ~~for trips~~

- Add Google Map API Stuff
- Make landing page one of those scroll for content types
	-         Maybe with parallax effect?
- Calendar function
	- fixes [3]
	- calendar export
	- calendar sync
- Image gallery
	-         fixes [5]
- Modules:
	- User Management
		- Database
		- User Model / Data Model
		- Athentification logic
			- use data base
			- secure data base
	- Inventory Management
		- Database
		- Item Model
	- Trip Management
		- Database
		- Trip Model


---
## Input Adlys
1. WM-Logo oben links auf der Home-Website
2. Jede Gruppe eigenes Gruppenbild (In Kluft)
3. Termine auf der rechten Seite: Einfach immer die nächsten drei Veranstaltungen anzeigen
anstatt nur "Keine Veranstaltungen gefunden"
	- kalender wöchentlich (?)
4. Kontakte: Eine Telefonnummer hinterlassen
5. Bildergalerie?
6. Sippe  erklären ihr Sippen Tier