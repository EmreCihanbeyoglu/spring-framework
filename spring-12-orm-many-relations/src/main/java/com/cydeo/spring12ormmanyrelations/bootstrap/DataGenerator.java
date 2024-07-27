package com.cydeo.spring12ormmanyrelations.bootstrap;

import com.cydeo.spring12ormmanyrelations.entity.*;
import com.cydeo.spring12ormmanyrelations.enums.Status;
import com.cydeo.spring12ormmanyrelations.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

@Component
public class DataGenerator implements CommandLineRunner {

    private final PaymentRepository paymentRepository;
    private final PaymentDetailRepository paymentDetailRepository;
    private final MerchantRepository merchantRepository;
    private final CustomerRepository customerRepository;
    private final ItemRepository itemRepository;
    private final CartRepository cartRepository;

    @Autowired
    public DataGenerator(PaymentRepository paymentRepository, PaymentDetailRepository paymentDetailRepository, MerchantRepository merchantRepository, CustomerRepository customerRepository, ItemRepository itemRepository, CartRepository cartRepository) {
        this.paymentRepository = paymentRepository;
        this.paymentDetailRepository = paymentDetailRepository;
        this.merchantRepository = merchantRepository;
        this.customerRepository = customerRepository;
        this.itemRepository = itemRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Payment payment1 = new Payment(new BigDecimal("150000"), LocalDate.of(2022, 4, 19), Status.SUCCESS);
        PaymentDetail paymentDetail1 = new PaymentDetail(new BigDecimal("140000"),new BigDecimal("10000"), LocalDate.of(2022, 4, 24));

        payment1.setPaymentDetail(paymentDetail1);


        Payment payment2 = new Payment(new BigDecimal("100000"), LocalDate.of(2022, 4, 25), Status.SUCCESS);
        PaymentDetail paymentDetail2 = new PaymentDetail(new BigDecimal("90000"),new BigDecimal("10000"), LocalDate.of(2022, 4, 24));

        payment2.setPaymentDetail(paymentDetail2);



        Merchant merchant1 = new Merchant("AmazonSubMerchant", "M123", new BigDecimal("0.25"), new BigDecimal("3.25"), 5);

        payment1.setMerchant(merchant1);
        payment2.setMerchant(merchant1);

        Customer customer1 = new Customer("Stuajordet 261", "mrcihanbeyoglu@gmail.com", "Emre", "Cihan", "EmreCihan");
        payment1.setCustomer(customer1);
        payment2.setCustomer(customer1);


        Item item1 = new Item("Milk", "M01");
        Item item2 = new Item("Egg", "E01");
        Item item3 = new Item("Apple", "F01");

        Cart cart1 = new Cart();
        Cart cart2 = new Cart();

        cart1.setItemList(Arrays.asList(item1, item2, item3));
        cart2.setItemList(Arrays.asList(item1, item3));


        merchantRepository.save(merchant1);
        customerRepository.save(customer1);
        paymentRepository.save(payment1);
        paymentRepository.save(payment2);

        itemRepository.save(item1);
        itemRepository.save(item2);
        itemRepository.save(item3);

        cartRepository.save(cart1);
        cartRepository.save(cart2);


//        // since we have used cascading, no need to save them explicitly, they will be saved already
//        // while saving payments to payments table
//        paymentDetailRepository.save(paymentDetail1);
//        paymentDetailRepository.save(paymentDetail2);



    }
}
