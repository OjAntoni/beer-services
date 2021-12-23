package guru.springframework.msscbrewery.bootstrap;

import guru.springframework.msscbrewery.domain.Beer;
import guru.springframework.msscbrewery.repository.BeerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Slf4j
@AllArgsConstructor
@Component
public class BeerLoader implements CommandLineRunner {
    private final BeerRepository beerRepository;

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if (beerRepository.count() == 0) {

            beerRepository.save(Beer.builder()
                    .beerName("Mango Bobs")
                    .beerStyle("IPA")
                    .quantityToBrew(200)
                    .upc(17451041050L)
                    .price(new BigDecimal("12.66"))
                    .minOnHand(2)
                    .build()
            );

            beerRepository.save(Beer.builder()
                    .beerName("Alivaryja")
                    .beerStyle("PILSNER")
                    .quantityToBrew(280)
                    .upc(274510769L)
                    .price(new BigDecimal("7"))
                    .minOnHand(4)
                    .build()
            );

            log.info("Loaded Beers: " + beerRepository.count());
        }
    }
}
