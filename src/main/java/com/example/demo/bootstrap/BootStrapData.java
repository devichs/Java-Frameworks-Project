package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.InhousePartRepository;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;
    private final InhousePartRepository inhousePartRepository;
    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, InhousePartRepository inhousePartRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.inhousePartRepository = inhousePartRepository;
        this.outsourcedPartRepository = outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {
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

            System.out.println("Started in Bootstrap");
            System.out.println("Number of Products" + productRepository.count());
            System.out.println(productRepository.findAll());
            System.out.println("Number of Parts" + partRepository.count());
            System.out.println(partRepository.findAll());
        }
    }
}
