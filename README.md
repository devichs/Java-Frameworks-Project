## D287 – JAVA FRAMEWORKS.
My project will keep track of inventory for a customer that owns a music store.  The music store sells instruments and instrument parts.
### PERFORMANCE ASSESSMENT STEPS.  
**B. Create a README file that includes notes describing where in the code to find the changes you made for each of parts C to J. Each note should include the prompt, file name, line number, and change.**

#### filename: README.md
This entire file was updated from the original file to track other project file changes.

**C. Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.**
#### filename: mainscreen.html
line 14 changed title
```
<title>Wolfgang's Music Shop</title>
```
line 19 changed h1 tag, Shop
```
<h1>Wolfgang's Music Shop</h1>
```
line 21 changed h2 tag, Parts
```
<h2>Music Instrument Parts</h2>
```
lne 53 changed h2 tag, Products
```
<h2>Musical Instruments</h2>
```

**D.  Add an About page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.**
#### filename: mainscreen.html

line 20 added a button to navigate to an About Us page
```
<a href="/about" class="btn btn-primary btn-sm mb-3">About Us</a>
```
#### filename: about.html
added a template file called about.html.  With navigation back to mainscreen.html
```
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">

    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>About Wolfgang's Music Shop</title>
</head>
<body>
<div class="container">
    <h2>Welcome to Wolfgang's Music Shop</h2>
        <p>We believe you will find only the finest instruments and instrument parts in our store.
            We have gone to great lengths to make your online musical instrument shopping as smooth as possible.</p>
        <h3>Our Story</h3>
            <p>We have been selling musical instruments and parts for over 250 years.
            All these years of experience are now put to work for you, our customer.
            Please enjoy our store as much as you will enjoy our instruments.
            Thank you.</p>
    <a href="/mainscreen" class="btn btn-primary btn-sm mb-3">Back To The Home Page</a>
</div>
</body>
</html>
```
**E.  Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.**
#### filename: BootStrapData.java

Modified file by adding product and part information

line 32 added inhousePartRepository variable
```
    private final InhousePartRepository inhousePartRepository;
```
line 44 - 139 added 3 inhouse parts, 2 outsource parts and 5 new products
```
        if(inhousePartRepository.count() == 0) {

            List<InhousePart> inhouseParts = (List<InhousePart>) inhousePartRepository.findAll();

            //added three inhouse parts
            InhousePart inhouse1 = new InhousePart();
            inhouse1.setId(1);
            inhouse1.setName("Guitar Strings");
            inhouse1.setPrice(12.00);
            inhouse1.setInv(10);
            //inhouse1.setMinInv(1);
            //inhouse1.setMaxInv(100);
            inhousePartRepository.save(inhouse1);
            InhousePart theInPart = null;
            inhouseParts = (List<InhousePart>) inhousePartRepository.findAll();
            for (InhousePart part : inhouseParts) {
                if (part.getName().equals("Guitar Strings")) theInPart = part;
            }

            InhousePart inhouse2 = new InhousePart();
            inhouse2.setId(5);
            inhouse2.setName("Guitar Pick");
            inhouse2.setPrice(3.00);
            inhouse2.setInv(20);
            //inhouse2.setMinInv(1);
            //inhouse2.setMaxInv(100);
            inhousePartRepository.save(inhouse2);
            theInPart = null;
            inhouseParts = (List<InhousePart>) inhousePartRepository.findAll();
            for (InhousePart part : inhouseParts) {
                if (part.getName().equals("Guitar Pick")) theInPart = part;
            }

            InhousePart inhouse3 = new InhousePart();
            inhouse3.setId(9);
            inhouse3.setName("Amp Tube");
            inhouse3.setPrice(56.00);
            inhouse3.setInv(20);
            //inhouse3.setMinInv(1);
            //inhouse3.setMaxInv(100);
            inhousePartRepository.save(inhouse3);
            theInPart = null;
            inhouseParts = (List<InhousePart>) inhousePartRepository.findAll();
            for (InhousePart part : inhouseParts) {
                if (part.getName().equals("Amp Tube")) theInPart = part;
            }

            //added 2 outsourced parts
            List<OutsourcedPart> outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();

            OutsourcedPart o = new OutsourcedPart();
            o.setCompanyName("Musicians Friend");
            o.setName("Guitar Strap");
            o.setInv(5);
            o.setPrice(40.0);
            o.setId(101L);
            outsourcedPartRepository.save(o);
            OutsourcedPart theOutPart = null;
            outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for (OutsourcedPart part : outsourcedParts) {
                if (part.getName().equals("Guitar Strap")) theOutPart = part;
            }

            System.out.println(theOutPart.getCompanyName());

            OutsourcedPart o2 = new OutsourcedPart();
            o2.setCompanyName("Guitar World");
            o2.setName("Amplifier Power Cord");
            o2.setInv(5);
            o2.setPrice(25.0);
            o2.setId(105L);
            outsourcedPartRepository.save(o2);
            OutsourcedPart theOutPart2 = null;
            outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for (OutsourcedPart part : outsourcedParts) {
                if (part.getName().equals("Amplifier Power Cord")) theOutPart2 = part;
            }

            System.out.println(theOutPart.getCompanyName());

            outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for (OutsourcedPart part : outsourcedParts) {
                System.out.println(part.getName() + " " + part.getCompanyName());
            }

            //add five new products
            Product guitar = new Product("guitar", 1100.0, 15);
            Product drums = new Product("drums", 2200.0, 15);
            Product keyboard = new Product("keyboard", 1500.0, 15);
            Product violin = new Product("violin", 3500, 15);
            Product tuba = new Product("tuba", 400, 15);
            productRepository.save(guitar);
            productRepository.save(drums);
            productRepository.save(keyboard);
            productRepository.save(violin);
            productRepository.save(tuba);
```


**F.  Add a “Buy Now” button to your product list.**

**G.  Modify the parts to track maximum and minimum inventory:**

**•  Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs**

**•  Rename the file the persistent storage is saved to.**

**•  Modify the code to enforce that the inventory is between or at the minimum and maximum value.**

**H.  Add validation for between or at the maximum and minimum fields.**

**I.  Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.**

**J.  Remove the class files for any unused validators in order to clean your code.**

**K.  Demonstrate professional communication in the content and presentation of your submission.**
