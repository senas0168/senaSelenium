package day11;

import com.github.javafaker.Faker;
import org.junit.Test;

public class C02_JavaFaker {

    @Test
    public void javaFakerTest() {
        //  1.Faker objesi olusturulur
        Faker faker = new Faker();
        // 2. Faker objesi ile fake data olusturulur

        //first name datası
        String fName = faker.name().firstName();
        System.out.println(fName);

        //last name datası
        String lName = faker.name().lastName();
        System.out.println(lName);

        //kullanıcı adı
       String username= faker.name().username();
        System.out.println(username);

        //meslek ismi
        System.out.println(faker.name().title());

        //sehir
        System.out.println(faker.address().city());

        //eyalet
        System.out.println(faker.address().state());

        //full address
        System.out.println(faker.address().fullAddress());

        //cep telefon numarası
        System.out.println(faker.phoneNumber().cellPhone());

        //email
        System.out.println(faker.internet().emailAddress());

        //posta kodu
        System.out.println(faker.address().zipCode());

        //rasgele 10 haneli numara
        System.out.println(faker.number().digits(15));

        /*
        TEST DATA : kullanıcı adı, sifre, tel no, email,sehir, kredi kart no,...
        Test datalarını kimden alınır?
        1.BA-Business analyst(Acceptance Criteria lari yazar)
        2.Test Lead
        3.Manual Tester
        4.Tech Lead & Team Lead & Dev Lead
        5.Developer
        6.Database
        7.API call lar
        8.Documantasyonlar. Ornegin API swagger documanı.
        9.Java Faker da fake data almak icin kullanıyoruz
        NEREDEN GELMEZ: end user, kullanıcıdan, scrum master,
         */
    }
}
