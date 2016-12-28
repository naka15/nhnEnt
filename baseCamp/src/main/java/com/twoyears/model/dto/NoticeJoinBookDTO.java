// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   NoticeJoinBookDTO.java

package com.twoyears.model.dto;

import java.util.Date;

public class NoticeJoinBookDTO
{

    public NoticeJoinBookDTO()
    {
    }

    public NoticeJoinBookDTO(int noticeNo, String noticeTitle, Date noticeDate, String noticeStatus, String noticeContent, int noticeCount, String noticeMethod, 
            String noticeLocation, String bookSubject, int bookPrice, String bookISBN, String bookPic, String bookGenre, int bookNum, 
            String bookQty)
    {
        this.noticeNo = noticeNo;
        this.noticeTitle = noticeTitle;
        this.noticeDate = noticeDate;
        this.noticeStatus = noticeStatus;
        this.noticeContent = noticeContent;
        this.noticeCount = noticeCount;
        this.noticeMethod = noticeMethod;
        this.noticeLocation = noticeLocation;
        this.bookSubject = bookSubject;
        this.bookPrice = bookPrice;
        this.bookISBN = bookISBN;
        this.bookPic = bookPic;
        this.bookGenre = bookGenre;
        this.bookNum = bookNum;
        this.bookQty = bookQty;
    }

    public int getNoticeNo()
    {
        return noticeNo;
    }

    public void setNoticeNo(int noticeNo)
    {
        this.noticeNo = noticeNo;
    }

    public String getNoticeTitle()
    {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle)
    {
        this.noticeTitle = noticeTitle;
    }

    public Date getNoticeDate()
    {
        return noticeDate;
    }

    public void setNoticeDate(Date noticeDate)
    {
        this.noticeDate = noticeDate;
    }

    public String getNoticeStatus()
    {
        return noticeStatus;
    }

    public void setNoticeStatus(String noticeStatus)
    {
        this.noticeStatus = noticeStatus;
    }

    public String getNoticeContent()
    {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent)
    {
        this.noticeContent = noticeContent;
    }

    public int getNoticeCount()
    {
        return noticeCount;
    }

    public void setNoticeCount(int noticeCount)
    {
        this.noticeCount = noticeCount;
    }

    public String getNoticeMethod()
    {
        return noticeMethod;
    }

    public void setNoticeMethod(String noticeMethod)
    {
        this.noticeMethod = noticeMethod;
    }

    public String getNoticeLocation()
    {
        return noticeLocation;
    }

    public void setNoticeLocation(String noticeLocation)
    {
        this.noticeLocation = noticeLocation;
    }

    public String getBookSubject()
    {
        return bookSubject;
    }

    public void setBookSubject(String bookSubject)
    {
        this.bookSubject = bookSubject;
    }

    public int getBookPrice()
    {
        return bookPrice;
    }

    public void setBookPrice(int bookPrice)
    {
        this.bookPrice = bookPrice;
    }

    public String getBookISBN()
    {
        return bookISBN;
    }

    public void setBookISBN(String bookISBN)
    {
        this.bookISBN = bookISBN;
    }

    public String getBookPic()
    {
        return bookPic;
    }

    public void setBookPic(String bookPic)
    {
        this.bookPic = bookPic;
    }

    public String getBookGenre()
    {
        return bookGenre;
    }

    public void setBookGenre(String bookGenre)
    {
        this.bookGenre = bookGenre;
    }

    public int getBookNum()
    {
        return bookNum;
    }

    public void setBookNum(int bookNum)
    {
        this.bookNum = bookNum;
    }

    public String getBookQty()
    {
        return bookQty;
    }

    public void setBookQty(String bookQty)
    {
        this.bookQty = bookQty;
    }

    public String toString()
    {
        return (new StringBuilder("NoticeDTO [noticeNo=")).append(noticeNo).append(", noticeTitle=").append(noticeTitle).append(", noticeDate=").append(noticeDate).append(", noticeStatus=").append(noticeStatus).append(", noticeContent=").append(noticeContent).append(", noticeCount=").append(noticeCount).append(", noticeMethod=").append(noticeMethod).append(", noticeLocation=").append(noticeLocation).append(", bookSubject=").append(bookSubject).append(", bookPrice=").append(bookPrice).append(", bookISBN=").append(bookISBN).append(", bookPic=").append(bookPic).append(", bookGenre=").append(bookGenre).append(", bookNum=").append(bookNum).append(", bookQty=").append(bookQty).append("]").toString();
    }

    int noticeNo;
    String noticeTitle;
    Date noticeDate;
    String noticeStatus;
    String noticeContent;
    int noticeCount;
    String noticeMethod;
    String noticeLocation;
    String bookSubject;
    int bookPrice;
    String bookISBN;
    String bookPic;
    String bookGenre;
    int bookNum;
    String bookQty;
}
