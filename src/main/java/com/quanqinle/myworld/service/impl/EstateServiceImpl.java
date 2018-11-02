package com.quanqinle.myworld.service.impl;

import com.quanqinle.myworld.dao.CommunityRepository;
import com.quanqinle.myworld.dao.SecondHandHouseRepository;
import com.quanqinle.myworld.dao.SecondHandPriceRepository;
import com.quanqinle.myworld.dao.SecondHandListingRepository;
import com.quanqinle.myworld.entity.po.EstateCommunity;
import com.quanqinle.myworld.entity.po.EstateSecondHandHouse;
import com.quanqinle.myworld.entity.po.EstateSecondHandListing;
import com.quanqinle.myworld.entity.po.EstateSecondHandPrice;
import com.quanqinle.myworld.service.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author quanqinle
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class EstateServiceImpl implements EstateService {

	@Autowired
	CommunityRepository communityRepository;
	@Autowired
	SecondHandListingRepository secondHandListingRepository;
	@Autowired
	SecondHandHouseRepository secondHandHouseRepository;
	@Autowired
	SecondHandPriceRepository secondHandPriceRepository;

	@Override
	public List<EstateCommunity> saveCommunities(List<EstateCommunity> list) {
		return communityRepository.saveAll(list);
	}

	@Override
	public List<EstateSecondHandListing> saveSecondHandListings(List<EstateSecondHandListing> list) {
		return secondHandListingRepository.saveAll(list);
	}

	@Override
	public EstateSecondHandListing saveSecondHandListing(EstateSecondHandListing item) {
		return secondHandListingRepository.save(item);
	}

	/**
	 * 获取所有二手挂牌信息
	 * @return
	 */
	@Override
	public List<EstateSecondHandListing> getAllSecondHandListing() {
		return secondHandListingRepository.findAll();
	}

	@Override
	public boolean syncListingToOtherTables(@NotNull EstateSecondHandListing one) {

		String houseUniqueId = one.getFwtybh();
		String listingId = one.getGpid();

		EstateSecondHandHouse house = new EstateSecondHandHouse();
		EstateSecondHandPrice price = new EstateSecondHandPrice();

		if (secondHandHouseRepository.findByHouseUniqueId(houseUniqueId) == null) {
			// TODO
			house.setHouseUniqueId();
			house.setCityCode();
			house.setCityName();
			house.setCommunityId();
			house.setCommunityName();
			house.setCoveredArea();
			house.setDistrict();
			house.setHousePropertyOwnershipCertificate();
		}
		if (secondHandPriceRepository.findByHouseUniqueIdAndListingId(houseUniqueId,listingId) == null) {

		}

		return false;
	}
}
