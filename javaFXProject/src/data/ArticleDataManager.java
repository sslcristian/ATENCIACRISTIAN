package data;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Article;
import model.User;

public class ArticleDataManager {
    private static ArticleDataManager instance;
    private ArrayList<Article> articleList = new ArrayList<>();
    private static OracleDBConnection dbManager = new OracleDBConnection();


    public static ArticleDataManager getInstance() {
        if (instance == null) {
            instance = new ArticleDataManager();
        }
        return instance;
    }

    public ArrayList<Article> getArticles() {
        if (articleList.isEmpty()) {
        	getArticlesFromDatabase();  // Load from database if list is empty
        }
        return articleList;
    }


    private void getArticlesFromDatabase() {
        try {
            ArrayList<Article> articlesFromDb = dbManager.fetchArticles();
            articleList.clear();
            articleList.addAll(articlesFromDb);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // This method was modified to incorporate 
    public void addArticle(Article article) {
    	try {
    		articleList.add(article);
            dbManager.insertArticle(article);
        	 } catch (SQLException e) {
                 e.printStackTrace();
             }
    }
}
