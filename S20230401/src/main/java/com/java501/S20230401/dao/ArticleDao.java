package com.java501.S20230401.dao;

import java.util.List;

import com.java501.S20230401.model.Article;
import com.java501.S20230401.model.ArticleMember;
import com.java501.S20230401.model.Comm;
import com.java501.S20230401.model.MemberInfo;
import com.java501.S20230401.model.Region;
import com.java501.S20230401.model.Reply;
import com.java501.S20230401.util.SummaryType;

public interface ArticleDao {

	// 유현규
	public List<ArticleMember> getArticleSummary(int boardNum, SummaryType summaryType);
	public int insertArticle(Article article);
	public Article getArticleById(Article searcher);
	public MemberInfo getMemberInfoById(int mem_id);
	public ArticleMember getArticleMemberById(Article searcher);
	public List<ArticleMember> hgGetArticlesOfMember(int mem_id);
	public int hgIncreaseReadCount(Article searcher);
	public int hgRecommendArticle(Article searcher);
	public int hgCompressedUpdateArticle(Article article);
	public int hgDeleteArticle(Article article);
	public int hgRestoreArticle(Article article);
	public int hgInsertAdminArticle(Article article);
	public List<Article> hgAdminArticleList(Article searcher);
	
	
	// 양동균
	int allTotalArt(Article article);				// 글 카운트
	List<Article> allArticleList(Article article);	// 모든 글 조회
	Article detailShareArticle(Article article);	// 댓글
	int readShareArticle(Article article);			// 조회수
	int writeShareArticle(Article article);			// 글쓰기
	int dgDeleteArticle(Article article); 			// 글 삭제
	int dgVoteGood(Article article);				// 글 추천
	int dgVoteBad(Article article);					// 글 비추천
	int updateShare(Article article);				// 글 수정
	int dgReportArticle(Article article);

	
	// 백준
	Integer 						totalArticle(int brd_id);
	List<Article> 					articleTotal(Article article);
	Article 						detailContent(Article article);
	Integer							replyCount(int art_id);
	List<Article> 					artcleMenu(Article article);
	Integer 						upreadCount(Article article);
	List<Article> 					listMagnager();
	int 							bjWriteArticle(Article article);
	int 							bjUpdateArticle(Article article);
	int								delete(Article article);
	int 							replyWrite(Reply reply);
	int 							replyDelete(Reply reply);
	List<Article>					bjArtSearch(Article article);
	Integer 						bjGood(Article article);
	Integer							bjBad(Article article);
	
	// 임동빈
	int 			dbtotalArticle(Article article);
	List<Article> 	dbListArticle(Article article);
	Article 		dbdetailArticle(Article article);
	List<Article> 	dbreplyList(Article a);
	void 			dbWriteArticle(Article article);
	void 			dbUpdateArticle(Article article);
	int 			dbdeleteArticle(Article article);
	int 			dbReadArticleCnt(Article article);
	Article		    dbInsertReportArticle(Article article);
	Article			dbInsertReportReply(Article article);
	List<Article> 	dbTradeJoinMember(Article article);
	List<Article>	dbTradeWaitingMember(Article article);
	int 			dbTradeWaiting(Article article);
	int 			dbTradeInsertJoin(Article article);
	int 			dbTradeDeleteWaiting(Article article);
	int 			dbJoinDelete(Article article);
	int 			dbFavoriteArticle(Article article);
	int 			dbChangeStatus(Article article);
	int 			dbChangeEndStatus(Article article);
	int 			dbChangeCancelStatus(Article article);
	int 			dbArticleGoodUp(Article article);
	int 			dbArticleBadUp(Article article);
	int             dbReplyGoodUp(Article article);
	int				dbReplyBadUp(Article article);
	int 			dbCondArticleCnt(Article article);
	List<Article>   dbListSearchArticle(Article article);
	
	
	
	
	
	
	
	
	
	
	// 김찬영
	int				totalArticle();								
	List<Article> 	listArticle(Article article);				
//	List<Article> 	listReply(Article article);				
	Article			cyArticlereadDetail(Article article);		
	Article 		cyArticlereadupdate(Article article);		
	Article 		detatilArticle(int art_title);				
	int				cyArticleinsert(Article article);			
	int				cyArticlemodify(Article article);			
	public int 		cyArticledelete(Article article);			
	int				updateView(Article article);
	int				updateGood(Article article);
	int				updateBad(Article article);
//	public int 		totalArticleSearch(Article article);
	
	// 최승환
	List<Article> 	listCustomer(Article article);
	Article 		detailCustomer(Article article);
	List<Article> 	listCustomerMenu(Article article);
	int 			insertCustomer(Article article);
	int updateCustomer(Article article);
	int deleteCustomer(Article article);
	Integer customerViewCount(Article article);
	int totalCustomer(Article article);
	List<Article> shCustomerSearch(Article article);

	
	
	// 김진현
	List<Article> 			getDutchpayList(String boardName);
	Article                 detail2(Article article);
	public List<Article> 	repList2(Article article);
	public List<Comm>       payStatus2();
	public Article 			payStatusPro2(Article article);
	List<Comm>           	category2();
	List<Region>    		loc2();
	public void 			dutchpayInsert2(Article article);
	Article 				updateForm2(Article article);
	List<Region> 			loc_ud2();
	void 					dutchpayUpdate2(Article article);
	void 					dutchpayDelete2(Article article);
	public int 				DeatilRead2(Article article);
	public int 				totalArticle2();
	void                    applyInsert2(Article article);
	public Article 			applyCancel2(Article article);
	public Article 			joinCancel2(Article article);
	public List<Article>    joinList2(Article article);
	public List<Article>    waitList2(Article article);
	public Article 			joinDeny2(Article article);
	public Article          joinAccept2(Article article);
	public int              payCompleted2(int trd_id);
	
	
}