package com.java501.S20230401.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java501.S20230401.dao.ArticleDao;
import com.java501.S20230401.dao.CommDao;
import com.java501.S20230401.dao.RegionDao;
import com.java501.S20230401.dao.ReplyDao;
import com.java501.S20230401.model.Article;
import com.java501.S20230401.model.Member;
import com.java501.S20230401.model.Reply;
import com.java501.S20230401.model.ArticleMember;
import com.java501.S20230401.model.Comm;
import com.java501.S20230401.model.Region;
import com.java501.S20230401.util.SummaryType;
import com.java501.S20230401.model.Article_Trade_Reply;
import com.java501.S20230401.model.Comm;
import com.java501.S20230401.model.Region;
import com.java501.S20230401.model.MemberInfo;
import com.java501.S20230401.util.SummaryType;
import lombok.RequiredArgsConstructor;
import oracle.security.o3logon.a;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {
	private final ArticleDao 	ad;
	private final RegionDao 	rd;
	private final CommDao 		cd;
	private final ReplyDao 		rpd;


	// 유현규 로그인 기능 추가
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
	@Override
	public MemberInfo getMemberInfoById(int mem_id) {
		return ad.getMemberInfoById(mem_id);
	}
	@Override
	public ArticleMember getArticleMemberById(Article searcher) {
		return ad.getArticleMemberById(searcher);
	}

	// 양동균
	@Override
	public int allTotalArt(Article article) { return ad.allTotalArt(article); }
	@Override
	public List<Article> allArticleList(Article article) { return ad.allArticleList(article); }
	// 댓글
	@Override
	public Article detailShareArticle(Article article) { return ad.detailShareArticle(article); }
	@Override
	public int readShareArticle(Article article) {	return ad.readShareArticle(article); }
	// 글쓰기
	@Override
	public int writeShareArticle(Article article) {	return ad.writeShareArticle(article);}

	// 백준
	@Override
	public Integer totalArticle(int brd_id) {
		Integer totalArticleCnt = ad.totalArticle(brd_id);
		return totalArticleCnt;
	}
	@Override
	public List<Article> articleTotal(Article article) {
		List<Article> articleList = null;
		articleList = ad.articleTotal(article);
		return articleList;
	}
	@Override
	public Article detailContent(Article article) {
		Article detailCon = null;
		detailCon = ad.detailContent(article);
		return detailCon;
	}
	@Override
	public List<Article> articleMenu(Article article) {
		List<Article> articleMenu = null;
		articleMenu = ad.artcleMenu(article);
		return articleMenu;
	}
	@Override
	public Integer upreadCount(Article article) {
		return ad.upreadCount(article);
	}
	@Override
	public List<Article> listMagnager() {
		List<Article> bjwrite = null;
		bjwrite = ad.listMagnager();
		return bjwrite;
	}
	@Override
	public int bjWriteArticle(Article article) {
		int result = 0;
		result = ad.bjWriteArticle(article);
		return result;
	}
	@Override
	public int bjUpdateArticle(Article article) {
		int update = 0;
		update = ad.bjUpdateArticle(article);
		return update;
	}
	@Override
	public int delete(Article article) {
		int delResult = 0;
		delResult = ad.delete(article);
		return delResult;
	}
	
	// 임동빈
	
	// 총 게시글 수 Count
	@Override
	public int dbtotalArticle(Article article) {
		System.out.println("ArticleService Start total...");
		int totArticleCnt = ad.dbtotalArticle(article);
		System.out.println("ArticleServiceImpl totalArticle totArticleCnt-> " + totArticleCnt);

		return totArticleCnt;
	}
	// 게시글 리스트
	@Override
	public List<Article> dbListArticle(Article article) {
		List<Article> articleList = null;
		System.out.println("ArticleServiceImpl listManager Start...");
		articleList = ad.dbListArticle(article);
		System.out.println("ArticleServiceImpl listArticle ArticleList.size()->" + articleList.size());
		return articleList;
	}
	
	// 상세 게시글
	@Override
	public Article dbdetailArticle(Article article) {
		Article detailArticle = null;
		detailArticle = ad.dbdetailArticle(article);
		return detailArticle;
	}
	
	// 지역 제한 리스트
	@Override
	public List<Region> regionName() {
		List<Region> regionName = null;
		System.out.println("ArticleServiceImpl regionName start...");
		regionName = rd.regionName();
		System.out.println("ArticleServiceImpl regionName.size()=> " + regionName.size());
		
		return regionName;
	}

	// 부모 지역 제한 리스트
	@Override
	public List<Region> parentRegionName() {
		List<Region> parentRegionName = null;
		parentRegionName = rd.parentRegionName();
		return parentRegionName;
	}
	
	// 카테고리 이름 리스트
	@Override
	public List<Comm> categoryName() {
		List<Comm> categoryName = null;
		System.out.println("ArticleServiceImpl categoryName start...");
		categoryName = cd.boardName();
		System.out.println("ArticleServiceImpl commName.size()=> " + categoryName.size());
		return categoryName;
	}
	
	// 성별 리스트
	@Override
	public List<Comm> genderName() {
		List<Comm> genderName = null;
		System.out.println("ArticleServiceImpl categoryName start...");
		genderName = cd.genderName();
		System.out.println("ArticleServiceImpl commName.size()=> " + genderName.size());
		return genderName;
	}
	
	// 댓글 리스트
	@Override
	public List<Article> dbreplyList(Article article) {
		List<Article> replyList = ad.dbreplyList(article);
		return replyList;
	}
	
	// 게시글 작성
	@Override
	public void dbWriteArticle(Article article) {
		ad.dbWriteArticle(article);
		System.out.println("ArticleServiceImpl article.getInsert_result() => " + article.getInsert_result());
	}
	
	// 게시글 삭제
	@Override
	public int dbdeleteArticle(Article article) {	
		int deleteArticle = ad.dbdeleteArticle(article);
		System.out.println("ArticleServiceImpl deleteArticle.size()=> " + deleteArticle);
		return deleteArticle;
	}
	
	// 게시글 수정
	@Override
	public void dbUpdateArticle(Article article) {
		ad.dbUpdateArticle(article);
		System.out.println("ArticleServiceImpl article.getInsert_result())=> " + article.getInsert_result());
	}
	
	// 조회수 Count
	@Override
	public int dbReadArticleCnt(Article article) {
		int dbReadArticleCnt = ad.dbReadArticleCnt(article);
		return dbReadArticleCnt;
	}
	
	// 신고하기
	@Override
	@Transactional
	public void dbReportArtice(Article article) {
		ad.dbInsertReport(article);
		ad.dbUpdateReport(article);
	}
	
	
	
	
	
	
	
	// 김진현
	@Override
	public List<Article_Trade_Reply> getDutchpayList(String boardName) {
		List<Article_Trade_Reply> atr = ad.getDutchpayList(boardName);
		return atr;
	}

	@Override
	public Article_Trade_Reply detail1(Article_Trade_Reply atr) {
		Article_Trade_Reply atr1 = null;
		atr1 = ad.detail2(atr);
		return atr1;
	}

	@Override
	public List<Comm> category1() {
		List<Comm> cm = null;
		cm = ad.category2();
		return cm;
	}

	@Override
	public List<Region> loc1() {
		List<Region> re = null;
		re = ad.loc2();
		return re;
	}

	@Override
	public void dutchpayInsert1(Article_Trade_Reply atr) {
		ad.dutchpayInsert2(atr);
	}
	
	@Override
	public Article_Trade_Reply updateForm1(Article_Trade_Reply atr) {
		Article_Trade_Reply updateForm = null;
		updateForm = ad.updateForm2(atr);
		return updateForm;
	}

	@Override
	public List<Comm> category_ud1() {
		List<Comm> cm = null;
		cm = ad.category_ud2();
		return cm;
	}

	@Override
	public List<Region> loc_ud1() {
		List<Region> re = null;
		re = ad.loc_ud2();
		return re;
	}

	// 김찬영
	// 총리스트 	
	@Override
	public int totalArticle() {
		System.out.println("ArticleServiceImpl Start total...");
		int totArticleCnt = ad.totalArticle();
		System.out.println("ArticleServiceImpl totalArticle totArticleCnt->" + totArticleCnt);
		return totArticleCnt;
	}
	//리스트 조회
	@Override
	public List<Article> listArticle(Article article) {
		List<Article> articleList = null;
		System.out.println("ArticleServiceImpl listManager Start..");
		articleList = ad.listArticle(article);
		System.out.println("ArticleServiceImpl listArticle articleList.size()->" +articleList.size());
		return articleList;
	}
	// 상세페이지 조회
	@Override
	public Article cyArticlereadDetail(Article article) {
		System.out.println("ArticleServiceImpl Manager Start..");
		Article result = ad.cyArticlereadDetail(article);
		System.out.println("ArticleServiceImpl cyArticlereadDetail article->" +article);
		return result;
	}
	// 상세페이지?
	@Override
	public Article detailArticle(int art_title) {
		System.out.println("ArticleServiceImpl detail...");
		Article article = null;
		article = ad.detatilArticle(art_title);
		return article;
	}
	// 수정페이지 상세페이지
	@Override
	public Article cyArticlereadupdate(Article article) {
		System.out.println("ArticleServiceImpl Manager Start..");
		Article result = ad.cyArticlereadupdate(article);
		System.out.println("ArticleServiceImpl cyArticlereadDetail article->" +article);
		return result;
	}
	
	// 게시물 수정
	@Override
	public int cyArticlemodify(Article article) {
		System.out.println("ArticleServiceImpl update");
		int result = ad.cyArticlemodify(article);
		return result;
	}
	// 게시물 작성
	@Override
	public int cyArticleinsert(Article article) {
		System.out.println("ArticleServiceImpl insert...");
		int result = ad.cyArticleinsert(article);
		return result;
	}

	// 최승환
	@Override
	public int totalCustomer() {
		System.out.println("ArticleServiceImpl Start totalCustomer..." );
		int totCustomerCnt = ad.totalCustomer();
		System.out.println("ArticleServiceImpl totalCustomer totCustomerCnt->" + totCustomerCnt);
		return totCustomerCnt;
	}
	@Override
	public List<Article> listCustomer(Article article) {
		List<Article> customerList = null;
		System.out.println("ArticleServiceImpl listCustomer Start..." );
		customerList = ad.listCustomer(article);
		System.out.println("ArticleServiceImpl list customerList.size()->" +customerList.size());
		return customerList;
	}
	@Override
	public Article detailCustomer(Article article) {
		System.out.println("ArticleServiceImpl detailCustomer...");
		Article customerDetail = null;
		customerDetail = ad.detailCustomer(article);
		return customerDetail;
	}
	@Override
	public List<Article> listCustomerMenu(Article article) {
		List<Article> listMenu = null;
		listMenu = ad.listCustomerMenu(article);
		return listMenu;
	}
	@Override
	public int insertCustomer(Article article) {
		int result = 0;
		System.out.println("ArticleServiceImpl insertCustomer Start");
		result = ad.insertCustomer(article);
		return result;
	}
}