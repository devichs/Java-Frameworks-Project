## JAVA PROJECT.
This project was developed to keep track of inventory for a customer that owns a music store.  The music store sells instruments and instrument parts.

#### filename: README.md
This entire file was updated from the original file to track other project file changes.

**C. Customizations made for this project.**
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

**D.  Added an About page to the application.**
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
**E.  Added a sample inventory.**
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


**F.  Added a “Buy Now” button.**
#### filename: mainscreen.html

line 86 added reference to the Buy Now button
```angular2html
<a th:href="@{/buyProduct(productID=${tempProduct.id})}" class="btn btn-primary btn-sm mb-3">Buy Now</a>
```
#### filename: confirmPurchaseSuccess.html
added this file to show a good purchase
```angular2html
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

    <title>Successful Purchase!</title>
</head>
<body>
<h3>Your purchase was successful!  Enjoy your item!
    Please come again!</h3>
    <a href="/mainscreen" class="btn btn-primary btn-sm mb-3">Back To The Home Page</a>

</body>
</html>
```
#### filename: confirmPurchaseFailure
added this file to show a failed purchase
```angular2html
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

    <title>Purchase Failed!</title>
</head>
<body>
<h3>Purchase did not complete successfully!
    Please contact customer service.</h3>
    <a href="/mainscreen" class="btn btn-primary btn-sm mb-3">Back To The Home Page</a>

</body>
</html>
```
#### filename: BuyNowController.java
added this file to manage the Buy Now process.  It confirms whether product is in stock and if so, it will decrement the inventory by one and take the customer to a purchase confirmation page.  If not, it will take the customer to a failed purchase notification page. 
```angular2html
package com.example.demo.controllers;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Controller
public class BuyNowController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/buyProduct")
    public String buyProduct(@RequestParam("productID") Long theId, Model theModel){
        Optional<Product> productToBuy = productRepository.findById(theId);
        if (productToBuy.isPresent()) {
            Product product = productToBuy.get();
            product.setInv(product.getInv() -1);
            productRepository.save(product);
            return "/confirmPurchaseSuccess";
        }
        else {
            return "/confirmPurchaseFailure";
        }
    }
}
```
**G.  Modified the parts to track maximum and minimum inventory:**

**•  Added additional fields to the part entity for maximum and minimum inventory.**
#### filename: Part.java

lines 32-35 added variables minInv and maxInv within @Min and @Max with messages
```angular2html
    @Min(value = 0, message = "Minimum inventory amount is 0")
    int minInv;
    @Max(value = 50, message = "Maximum inventory amount is 50")
    int maxInv;
```
lines 45 - 59 added minInv and maxInv to both Part constructors
```angular2html
    public Part(String name, double price, int inv, int minInv, int maxInv) {
        this.name = name;
        this.price = price;
        this.inv = inv;
        this.minInv = 0;
        this.maxInv = 50;
    }

    public Part(long id, String name, double price, int inv, int minInv, int maxInv) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.inv = inv;
        this.minInv = 0;
        this.maxInv = 50;
    }
```
lines 102 - 116 added getters and setters for minInv and maxInv
```angular2html
    public int getMinInv() {
        return minInv;
    }

    public int getMaxInv(){
        return maxInv;
    }

    public void setMinInv(int minInv){
        this.minInv = minInv;
    }

    public void setMaxInv(int maxInv){
        this.maxInv = maxInv;
    }
```
#### filename: InhousePart.java
lines 17 - 20 added minInv and maxInv setting defaults
```angular2html
    public InhousePart() {
        this.minInv = 0;
        this.maxInv = 50;
    }
```
#### filename: OutsourcedPart.java
lines 17 - 20 added minInv and maxInv setting defaults
```angular2html
    public InhousePart() {
        this.minInv = 0;
        this.maxInv = 50;
    }
```
**•  Modify the sample inventory to include the maximum and minimum fields.**
#### filename: BootStrapData.java
lines 49 - 125 added setMinInv and setMaxInv to sample inventory
```angular2html
            InhousePart inhouse1 = new InhousePart();
            inhouse1.setId(1);
            inhouse1.setName("Guitar Strings");
            inhouse1.setPrice(12.00);
            inhouse1.setInv(10);
            inhouse1.setMinInv(1);
            inhouse1.setMaxInv(50);
            inhousePartRepository.save(inhouse1);
            InhousePart thePart = null;
            inhouseParts = (List<InhousePart>) inhousePartRepository.findAll();
            for (InhousePart part : inhouseParts) {
                if (part.getName().equals("Guitar Strings")) thePart = part;
            }

            InhousePart inhouse2 = new InhousePart();
            inhouse2.setId(5);
            inhouse2.setName("Guitar Pick");
            inhouse2.setPrice(3.00);
            inhouse2.setInv(20);
            inhouse2.setMinInv(1);
            inhouse2.setMaxInv(50);
            inhousePartRepository.save(inhouse2);
            thePart = null;
            inhouseParts = (List<InhousePart>) inhousePartRepository.findAll();
            for (InhousePart part : inhouseParts) {
                if (part.getName().equals("Guitar Pick")) thePart = part;
            }

            InhousePart inhouse3 = new InhousePart();
            inhouse3.setId(9);
            inhouse3.setName("Keyboard Stand");
            inhouse3.setPrice(56.00);
            inhouse3.setInv(20);
            inhouse3.setMinInv(1);
            inhouse3.setMaxInv(50);
            inhousePartRepository.save(inhouse3);
            thePart = null;
            inhouseParts = (List<InhousePart>) inhousePartRepository.findAll();
            for (InhousePart part : inhouseParts) {
                if (part.getName().equals("Amp Tube")) thePart = part;
            }

            //added 2 outsourced parts
            List<OutsourcedPart> outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();

            OutsourcedPart o = new OutsourcedPart();
            o.setCompanyName("Musicians Friend");
            o.setName("Guitar Strap");
            o.setInv(5);
            o.setPrice(40.0);
            o.setId(101L);
            o.setMinInv(1);
            o.setMaxInv(50);
            outsourcedPartRepository.save(o);
            OutsourcedPart theOutPart = null;
            outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for (OutsourcedPart part : outsourcedParts) {
                if (part.getName().equals("Guitar Strap")) theOutPart = part;
            }

            System.out.println(theOutPart.getCompanyName());

            OutsourcedPart o2 = new OutsourcedPart();
            o2.setCompanyName("Keyboard World");
            o2.setName("Music Stand");
            o2.setInv(5);
            o2.setPrice(25.0);
            o2.setId(105L);
            o2.setMinInv(1);
            o2.setMaxInv(50);
            outsourcedPartRepository.save(o2);
            OutsourcedPart theOutPart2 = null;
            outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for (OutsourcedPart part : outsourcedParts) {
                if (part.getName().equals("Amplifier Power Cord")) theOutPart2 = part;
            }
```
**•  Added to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.**
#### filename: InhousePartForm.html
lines 24 - 28 added minInv and maxInv text inputs
```angular2html
<p><input type="text" th:field="*{minInv}" placeholder="Minimum Inventory" class="form-control mb-4 col-4"/></p>
    <p th:if="${#fields.hasErrors('minInv')}" th:errors="*{minInv}">Minimum Inventory Error</p>

<p><input type="text" th:field="*{maxInv}" placeholder="Maximum Inventory" class="form-control mb-4 col-4"/></p>
    <p th:if="${#fields.hasErrors('maxInv')}" th:errors="*{maxInv}">Maximum Inventory Error</p>
```
#### filename: OutsourcedPartForm.html
lines 25 - 29 added minInv and maxInv text inputs
```angular2html
<p><input type="text" th:field="*{minInv}" placeholder="Minimum Inventory" class="form-control mb-4 col-4"/></p>
    <p th:if="${#fields.hasErrors('minInv')}" th:errors="*{minInv}">Minimum Inventory Error</p>

<p><input type="text" th:field="*{maxInv}" placeholder="Maximum Inventory" class="form-control mb-4 col-4"/></p>
    <p th:if="${#fields.hasErrors('maxInv')}" th:errors="*{maxInv}">Maximum Inventory Error</p>
```
**•  Rename the file the persistent storage is saved to.**
#### filename: application.properties
line 6 modified spring.datasource.url=jdbc:h2:file: from ~/spring-boot-h2-db102  to db103 and subsequently to db104
```angular2html
spring.datasource.url=jdbc:h2:file:~/spring-boot-h2-db104
```
**•  Modify the code to enforce that the inventory is between or at the minimum and maximum value.**
#### filename: Part.java
lines 131 - 138 added enforceInvLimits() method
```angular2html
    public void enforceInvLimits(){
        if(this.inv < this.minInv) {
            throw new RuntimeException("Entered inventory value less than the set minimum allowed.");
        }
        else if (this.inv > this.maxInv) {
            throw new RuntimeException("Entered inventory value exceeds the set maximum allowed.");
        }
    }
```
#### filename: PartServiceImpl.java
lines 58 - 63 added enforceInvLimits to the save method
```angular2html
    @Override
    public void save(Part thePart) {
        thePart.enforceInvLimits();
            partRepository.save(thePart);

    }
```
#### filename: InhousePartServiceImpl.java
lines 52 -57 added enforceInvLimits to the save method
```angular2html
    @Override
    public void save(InhousePart thePart) {
        thePart.enforceInvLimits();
        partRepository.save(thePart);

    }
```
#### filename: OutsourcedPartServiceImpl.java
lines 50 -55 added enforceInvLimits to the save method
```angular2html
   @Override
    public void save(OutsourcedPart thePart) {
        thePart.enforceInvLimits();
        partRepository.save(thePart);

}
```
**H.  Added validation for between or at the maximum and minimum fields.**
**•  Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.**
Two new validation related files created: 
#### filename: ValidMinInv.java
Generates an error message when default minimum inventory is violated.
Validated by MinInvValidator.java
```angular2html
package com.example.demo.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 *
 *
 *
 */
@Constraint(validatedBy = {MinInvValidator.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidMinInv {
    String message() default "Inventory cannot be set below the default minimum amount.";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
```
#### filename: MinInvValidator.java
```angular2html
package com.example.demo.validators;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 *
 *
 *
 */
public class MinInvValidator implements ConstraintValidator<ValidMinInv, Part> {
    @Autowired
    private ApplicationContext context;
    public static  ApplicationContext myContext;

    @Override
    public void initialize(ValidMinInv constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
    @Override
    public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext){
        return part.getInv() > part.getMinInv();
    }
}
```
**•  Added error messages for low inventory when adding and updating products lowers the part inventory below the minimum.**
#### filename: Part.java
line 4 added import of minimum and maximum validators
```angular2html
import com.example.demo.validators.ValidMinInv;
```
line 25
```angular2html
@ValidMinInv
```
#### filename: EnufPartsValidator.java
lines 28 - 47 added an additional message to the isValid to show if part request is beyond defaults
```angular2html
    @Override
    public boolean isValid(Product product, ConstraintValidatorContext constraintValidatorContext) {
        if(context==null) return true;
        if(context!=null)myContext=context;
        ProductService repo = myContext.getBean(ProductServiceImpl.class);
        if (product.getId() != 0) {
            Product myProduct = repo.findById((int) product.getId());
            for (Part p : myProduct.getParts()) {
                if (p.getInv()<(product.getInv()-myProduct.getInv())){
                    constraintValidatorContext.disableDefaultConstraintViolation();
                    constraintValidatorContext.buildConstraintViolationWithTemplate("Not enough inventory for part, " + p.getName()).addConstraintViolation();
                    return false;
                }
            }
            return true;
        }
        else{
                return true;
            }
    }
```
**•  Added error messages when adding and updating parts if the inventory is greater than the maximum.**
Two new validation related files created:
#### filename: ValidMaxInv.java
Generates an error message when default maximum inventory is violated.
Validated by MaxInvValidator.java
```angular2html
package com.example.demo.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 *
 *
 *
 */

@Constraint(validatedBy = {MaxInvValidator.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidMaxInv {
    String message() default "Inventory cannot be set above the default maximum amount.";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
```
#### filename: MaxInvValidator.java
```angular2html
package com.example.demo.validators;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 *
 *
 *
 */
public class MaxInvValidator implements ConstraintValidator<ValidMaxInv, Part> {
    @Autowired
    private ApplicationContext context;
    public static  ApplicationContext myContext;

    @Override
    public void initialize(ValidMaxInv constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
    @Override
    public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext){
        return part.getInv() < part.getMaxInv();
    }
}
```
#### filename: Part.java
line 5 added import of minimum and maximum validators
```angular2html

import com.example.demo.validators.ValidMaxInv;
```
line 26
```angular2html
@ValidMinInv
@ValidMaxInv
```
#### filename: InhousePartForm.html
lines 32 - 36 added div to show any errors during form operation
```angular2html
    <div th:if="${#fields.hasErrors()}">
        <ul>
            <li th:each="err : ${#fields.allErrors()}" th:text="${err}" class="error"/>
        </ul>
    </div>
```
#### filename: OutsourcedPartForm.html
lines 33 - 37 added div to show any errors during form operation
```angular2html
    <div th:if="${#fields.hasErrors()}">
        <ul>
            <li th:each="err : ${#fields.allErrors()}" th:text="${err}" class="error"/>
        </ul>
    </div>
```
**I.  Added two unit tests for the maximum and minimum fields to the PartTest class in the test package.**
#### filename: PartTest.java
lines 95 - 111 added two unit tests on getMinInv() and getMaxInv()
```angular2html
    @Test
    void getMinInv(){
        int mininv = 0;
        partIn.setMinInv(mininv);
        assertEquals(mininv,partIn.getMinInv());
        partOut.setMinInv(mininv);
        assertEquals(mininv,partOut.getMinInv());
    }

    @Test
    void getMaxInv(){
        int maxinv = 50;
        partIn.setMaxInv(maxinv);
        assertEquals(maxinv,partIn.getMaxInv());
        partOut.setMaxInv(maxinv);
        assertEquals(maxinv,partOut.getMaxInv());
    }
```
**J.  Removed the class files for any unused validators in order to clean your code.**

Referencing: 
```
https://www.jetbrains.com/help/phpstorm/php-unused-declaration.html
```
From Code ->Inspect Code -> Whole Project: 
Two validator files were returned.  Both are showing as never used. 
These two files were removed from the project: 
#### filename: DeletePartValidator.java
#### filename: ValidDeletePart.java

**Revision attempt 1.**

E. Sample Inventory.  Product list is empty. 

#### filename: BootStrapData.java
Updated the adding of products to the product repository by adding a count check.
```angular2html
            if(productRepository.count() == 0) {
                Product guitar = new Product("Guitar", 1100.0, 30);
                Product drums = new Product("Drums", 2200.0, 30);
                Product keyboard = new Product("Keyboard", 1500.0, 30);
                Product violin = new Product("Violin", 3500.0, 30);
                Product tuba = new Product("Tuba", 400.0, 30);

                productRepository.save(guitar);
                productRepository.save(drums);
                productRepository.save(keyboard);
                productRepository.save(violin);
                productRepository.save(tuba);

                System.out.println("Started in Bootstrap");
                System.out.println("Number of Products" + productRepository.count());
                System.out.println(productRepository.findAll());
                System.out.println("Number of Parts" + partRepository.count());
                System.out.println(partRepository.findAll());
            }
```
H. Added validation.

Updated both MinInvValidator and MaxInvValidator to include the min allowed value of 1 and max allowed value of 50
#### filename: MinInvValidator.java
return part.getInv() >= part.getMinInv();
#### filename: MaxInvValidator.java
return part.getInv() <= part.getMaxInv();

Updated the BuyNowController with an additional else to show the confirmPurchaseFailure.html page if inventory is not at min or max.
#### filename: BuyNowController.java
```angular2html
public class BuyNowController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/buyProduct")
    public String buyProduct(@RequestParam("productID") Long theId, Model theModel){
        Optional<Product> productToBuy = productRepository.findById(theId);
        if (productToBuy.isPresent()) {
            Product product = productToBuy.get();
            if(product.getInv() > 0) {
                product.setInv(product.getInv() - 1);
                productRepository.save(product);
                return "/confirmPurchaseSuccess";
            }
            else{
                return "/confirmPurchaseFailure";
            }
        }
        else{
            return "/confirmPurchaseFailure";
        }
    }
}
```
