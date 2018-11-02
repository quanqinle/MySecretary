package com.quanqinle.myworld.entity.po;

import lombok.Data;

import javax.persistence.*;

/**
 * @author quanqinle
 */
@Entity
@Table(name = "estate_secondhand_price")
@Data
public class EstateSecondHandPrice {
	/**
	 * Constructor for jpa
	 */
	public EstateSecondHandPrice() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	/**
	 * 房源核验统一编码
	 */
	private String houseUniqueId;
	/**
	 * 挂牌id
	 */
	private String listingId;
	/**
	 * 委托出售价格
	 */
	private String salePrice;
	/**
	 * 委托协议创建时间
	 */
	private String entrustTime;
	/**
	 * 挂牌房屋id
	 */
	private String listingHouseId;
	/**
	 * 挂牌联系人姓名
	 */
	private String listingContactName;
	/**
	 * 挂牌状态id
	 */
	private String listingStatus;
	/**
	 * 挂牌状态
	 */
	private String listingStatusValue;
	/**
	 * 门店名称
	 */
	private String realEstateAgency;
	/**
	 * 首次挂牌上市时间（政府网站公示）
	 */
	private String listingTime;
	/**
	 * 统一挂牌编号
	 */
	private String listingUniqueId;
	/**
	 * 委托协议编号
	 */
	private String entrustAgreementId;
}
