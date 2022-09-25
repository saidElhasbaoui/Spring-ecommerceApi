package com.miniprojet.projet;

import com.miniprojet.projet.beans.*;
import com.miniprojet.projet.repositories.AppRoleRepos;
import com.miniprojet.projet.repositories.AppUserRepos;
import com.miniprojet.projet.repositories.CommandRepos;
import com.miniprojet.projet.repositories.ProductRepos;
import com.miniprojet.projet.security.AppRole;
import com.miniprojet.projet.security.AppUser;
import com.miniprojet.projet.security.Role;
import com.miniprojet.projet.services.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.List;

@SpringBootTest
class ProjetApplicationTests {

	@Autowired
	AccountService accountService;

	@Autowired
	AppRoleRepos appRoleRepos;

	@Autowired
	AppUserRepos appUserRepos;

	@Autowired
	CommandRepos commandRepos;

	@Autowired
	ProductRepos productRepos;

	@Autowired
	ProductService productService;

	@Autowired
	CategoryService categoryService;

	@Autowired
	CorporateService corporateService;

	@Autowired
	ClientService clientService;

	@Autowired
	CommandItemService commandItemService;

	@Autowired
	CommandService commandService;

	@Autowired
	ComponentService componentService;

	@Autowired
	OriginService originService;

	@Autowired
	RawMaterialService rawMaterialService;




	Client client1=Client.builder()
			.cin("cin1")
			.build();
	Client client2=Client.builder()
			.cin("cin2")
			.build();
	Client client3=Client.builder()
			.cin("cin3")
			.build();

	Corporate corporate1=Corporate.builder()
			.name("corporate1")
			.build();
	Corporate corporate2=Corporate.builder()
			.name("corporate2")
			.build();
	Corporate corporate3=Corporate.builder()
			.name("corporate3")
			.build();

	Category category1=Category.builder()
			.name("category1")
			.build();
	Category category2=Category.builder()
			.name("category2")
			.build();
	Category category3=Category.builder()
			.name("category3")
			.build();

	Origin origin1=Origin.builder()
			.name("casablanca")
			.build();
	Origin origin2=Origin.builder()
			.name("agadir")
			.build();
	Origin origin3=Origin.builder()
			.name("maroc")
			.build();

	RawMaterial rawMaterial1=RawMaterial.builder()
			.name("milk")
			.build();
	RawMaterial rawMaterial2=RawMaterial.builder()
			.name("thee")
			.build();
	RawMaterial rawMaterial3=RawMaterial.builder()
			.name("choco")
			.build();

	Product product1=Product.builder()
			.name("milk with choco")
			.category(category1)
			.quantity(20.0)
			.price(30.5)
			.corporate(corporate1)
			.build();
	Product product2=Product.builder()
			.name("thee with choco")
			.category(category2)
			.quantity(10.0)
			.price(21.0)
			.corporate(corporate1)
			.build();
	Product product3=Product.builder()
			.name("milk with thee")
			.category(category1)
			.quantity(25.0)
			.price(35.5)
			.corporate(corporate2)
			.build();

	Component component1=Component.builder()
			.product(product1)
			.origin(origin1)
			.percentage(30.0)
			.rawMaterial(rawMaterial1)
			.build();
	Component component2=Component.builder()
			.product(product1)
			.origin(origin2)
			.percentage(70.0)
			.rawMaterial(rawMaterial3)
			.build();
	Component component3=Component.builder()
			.product(product2)
			.origin(origin3)
			.percentage(70.0)
			.rawMaterial(rawMaterial2)
			.build();
	Component component4=Component.builder()
			.product(product2)
			.origin(origin1)
			.percentage(30.0)
			.rawMaterial(rawMaterial3)
			.build();
    Component component5=Component.builder()
            .product(product3)
            .origin(origin2)
            .percentage(70.0)
            .rawMaterial(rawMaterial1)
            .build();
    Component component6=Component.builder()
            .product(product3)
            .origin(origin3)
            .percentage(30.0)
            .rawMaterial(rawMaterial2)
            .build();

	Command command1=Command.builder()
			.client(client1)
			.build();
    Command command2=Command.builder()
            .client(client2)
            .build();


	CommandItem commandItem1=CommandItem.builder()
			.command(command1)
			.quantity(5.0)
			.build();
	CommandItem commandItem2=CommandItem.builder()
			.command(command1)
			.quantity(10.0)
			.build();

    CommandItem commandItem3=CommandItem.builder()
            .command(command2)
            .quantity(1.0)
            .build();
    CommandItem commandItem4=CommandItem.builder()
            .command(command2)
            .quantity(1.0)
            .build();



	@Test
	public void addProduct() {
		productService.add(product1);
		productService.add(product2);
		productService.add(product3);
	}

	@Test
	public void addClient(){
		clientService.add(client1);
		clientService.add(client2);
		clientService.add(client3);
	}

	@Test
	public void addOrigin(){
		originService.add(origin1);
		originService.add(origin2);
		originService.add(origin3);
	}

	@Test
	public void addRawMaterial(){
		rawMaterialService.add(rawMaterial1);
		rawMaterialService.add(rawMaterial2);
		rawMaterialService.add(rawMaterial3);
	}

	@Test
	public void addCategory(){
		categoryService.add(category1);
		categoryService.add(category2);
		categoryService.add(category3);
	}

	@Test
	public void addCorporate(){
		corporateService.add(corporate1);
		corporateService.add(corporate2);
		corporateService.add(corporate3);
	}

	@Test
	public void addComponentsProduct(){
        componentService.addAll(
                List.of(new Component[]{
                        component1 ,
                        component2
                })
        );

        componentService.addAll(
                List.of(new Component[]{
                        component3 ,
                        component4
                })
        );

        componentService.addAll(
                List.of(new Component[]{
                        component5 ,
                        component6
                })
        );
	}

	@Test
	public void addCommandItems(){
		commandItem3.setProduct(productService.findById(1L));
		commandItem4.setProduct(productService.findById(2L));

		commandItemService.addAll(List.of(new CommandItem[]{commandItem3, commandItem4}));
	}

	@Test
	public void showUs(){
		List<Product> products=productRepos.findAllByCategoryId(1L);
		for (Product product:products) {
			System.out.println(product.getName());
		}
	}

	@Test
	public void security(){
		AppRole appRole=appRoleRepos.findById(1L).stream().findFirst().orElse(null);
		accountService.addRoleToUser("driss",appRole);
	}

}
