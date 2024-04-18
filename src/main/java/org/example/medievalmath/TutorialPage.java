package org.example.medievalmath;

import javafx.scene.image.Image;
import javafx.scene.web.WebView;

public class TutorialPage extends Page
{
    private WebView videoWebView;

    public TutorialPage(Image backgroundImage, String videoUrl) {
        super(backgroundImage);
        this.videoWebView = new WebView();
        loadVideo(videoUrl);
    }

    // Getter and setter for videoWebView
    public WebView getVideoWebView() {
        return videoWebView;
    }

    public void setVideoWebView(WebView videoWebView) {
        this.videoWebView = videoWebView;
    }

    // Method to load and display video content
    public void loadVideo(String videoUrl) {
        videoWebView.getEngine().load(videoUrl);
        videoWebView.setMaxWidth(500);
        videoWebView.setMaxHeight(281);
    }
}
