package com.quanqinle.myworld.dao;

import com.quanqinle.myworld.entity.po.VideoInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author quanql
 */
public interface VideoInfoRepository extends JpaRepository<VideoInfo, Integer> {

	/**
	 * 获取视频信息
	 *
	 * @param videoName
	 * @return
	 */
	VideoInfo findByVideoName(String videoName);

	/**
	 * 获取所有未发布的视频
	 * @param siteId
	 * @return
	 */
	@Query(value="select t.* from video_info t where t.video_id not in (select a.video_id from video_upload a where a.site_id=?1 and a.state=0) order by t.video_id;", nativeQuery = true)
	List<VideoInfo> findAllNotPublished(int siteId);
}
