package Zade.Server;

import Zade.Server.Assets.Asset;
import org.springframework.data.jpa.repository.JpaRepository;

/*
Injected by constructor into the controll
 */
interface AssetRepository extends JpaRepository<Asset, Long> {
}