package com.java501.S20230401.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.java501.S20230401.dao.ArticleDao;
import com.java501.S20230401.dao.CommDao;
import com.java501.S20230401.dao.RegionDao;
import com.java501.S20230401.dao.ReplyDao;
import com.java501.S20230401.model.Article;
import com.java501.S20230401.model.ArticleMember;
import com.java501.S20230401.model.Comm;
import com.java501.S20230401.model.Region;
import com.java501.S20230401.util.SummaryType;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

	private final ArticleDao 	ad;
	private final RegionDao 	rd;
	private final CommDao 		cd;
	private final ReplyDao 		rpd;

	@Override
	public int totalArticle(Article article) {
		System.out.println("ArticleService Start total...");
		int totArticleCnt = ad.totalArticle(article);
		System.out.println("ArticleServiceImpl totalArticle totArticleCnt-> " + totArticleCnt);

		return totArticleCnt;
	}
	

	@Override
	public List<Article> listArticle(Article article) {
		List<Article> articleList = null;
		System.out.println("ArticleServiceImpl listManager Start...");
		articleList = ad.listArticle(article);
		System.out.println("ArticleServiceImpl listArticle ArticleList.size()->" + articleList.size());
		return articleList;
	}


	@Override
	public Article detailArticle(Article article) {
		Article detailArticle = null;
		detailArticle = ad.detailArticle(article);
		return detailArticle;
	}


	@Override
	public List<Region> regionName() {
		List<Region> regionName = null;
		System.out.println("ArticleServiceImpl regionName start...");
		regionName = rd.regionName();
		System.out.println("ArticleServiceImpl regionName.size()=> " + regionName.size());
		
		return regionName;
	}

	@Override
	public List<Region> parentRegionName() {
		List<Region> parentRegionName = null;
		parentRegionName = rd.parentRegionName();
		return parentRegionName;
	}

	@Override
	public List<Comm> categoryName() {
		List<Comm> categoryName = null;
		System.out.println("ArticleServiceImpl categoryName start...");
		categoryName = cd.boardName();
		System.out.println("ArticleServiceImpl commName.size()=> " + categoryName.size());
		return categoryName;
	}
	
	@Override
	public List<Comm> genderName() {
		List<Comm> genderName = null;
		System.out.println("ArticleServiceImpl categoryName start...");
		genderName = cd.genderName();
		System.out.println("ArticleServiceImpl commName.size()=> " + genderName.size());
		return genderName;
	}


//	@Override
//	public int favoriteCount(Article a) {
//		int favoriteCount = ad.favoriteCount(a);
//		return favoriteCount;
//	}

	@Override
	public List<Article> replyList(Article article) {
		List<Article> replyList = ad.replyList(article);
		return replyList;
	}

//	@Override
//	public int insertTrade(Article article) {
//		
//		int insertTrade = ad.insertTrade(article);
//		System.out.println("ArticleServiceImpl insertTrade.size()-> " + insertTrade);
//		return insertTrade;
//	}
	@Override
	public void writeArticle(Article article) {
		ad.writeArticle(article);
		System.out.println("ArticleServiceImpl article.getInsert_result() => " + article.getInsert_result());
	}


	@Override
	public int deleteArticle(Article article) {
		
		int deleteArticle = ad.deleteArticle(article);
		System.out.println("ArticleServiceImpl deleteArticle.size()=> " + deleteArticle);
		return deleteArticle;
	}


	@Override
	public void updateArticle(Article article) {
		ad.updateArticle(article);
		System.out.println("ArticleServiceImpl article.getInsert_result())=> " + article.getInsert_result());
	}
	
	@Override
	public List<ArticleMember> getArticleSummary(int boardNum, SummaryType summaryType) {
		List<ArticleMember> articleList = ad.getArticleSummary(boardNum, summaryType);
		return articleList;
	}
	
	@Override
	public int insertArticle(Article article) {
		int result = ad.insertArticle(article);
		return result;
	}
	
	@Override
	public Article getArticleById(Article searcher) {
		return ad.getArticleById(searcher);
	}


//	@Override
//	public int insertReply(Article article) {
//		int insertReply = rpd.insertReply(article);
//		return insertReply;
//	}




}
