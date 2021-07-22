package com.sdjictec.xdfin.regulatory.report.util;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.sdjictec.xdfin.regulatory.report.entity.*;
import com.sdjictec.xdfin.regulatory.report.listener.*;

import java.io.IOException;
import java.util.List;

public class EasyXlsUtil {
    //对公客户
    public static List<DgkhxxInfo> saxReadDgkhxxInfo(String pathFile) throws IOException {
        DgkhxxInfoListener dgkhxxListener = new DgkhxxInfoListener();
        ExcelReader excelReader = EasyExcel.read(pathFile, DgkhxxInfo.class, dgkhxxListener).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        excelReader.finish();
        return dgkhxxListener.getDgkhxxList();
    }
    //存款发生
    public static List<FtydwckfsxxInfo> saxReadFtydwckfsxxInfo(String pathFile) throws IOException {
        FtydwckfsxxInfoListener ftydwckfsxxInfoListener = new FtydwckfsxxInfoListener();
        ExcelReader excelReader = EasyExcel.read(pathFile, FtydwckfsxxInfo.class, ftydwckfsxxInfoListener).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        excelReader.finish();
        return ftydwckfsxxInfoListener.getFtydwckfsxxInfoList();
    }
    //存款基础
    public static List<FtydwckjcxxInfo> saxReadFtydwckjcxxInfo(String pathFile) throws IOException {
        FtydwckjcxxInfoListener ftydwckjcxxInfoListener = new FtydwckjcxxInfoListener();
        ExcelReader excelReader = EasyExcel.read(pathFile, FtydwckjcxxInfo.class, ftydwckjcxxInfoListener).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        excelReader.finish();
        return ftydwckjcxxInfoListener.getFtydwckjcxxInfoList();
    }
    //存款发生额
    public static List<FtydwckyexxInfo> saxReadFtydwckyexxInfo(String pathFile) throws IOException {
        FtydwckyexxInfoListener ftydwckyexxInfoListener = new FtydwckyexxInfoListener();
        ExcelReader excelReader = EasyExcel.read(pathFile, FtydwckyexxInfo.class, ftydwckyexxInfoListener).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        excelReader.finish();
        return ftydwckyexxInfoListener.getFtydwckyexxInfoList();
    }

    //贷款放款
    public static List<FtydwdkfkxxInfo> saxReadFtydwdkfkxxInfo(String pathFile) throws IOException {
        FtydwdkfkxxInfoListener ftydwdkfkxxInfoListener = new FtydwdkfkxxInfoListener();
        ExcelReader excelReader = EasyExcel.read(pathFile, FtydwdkfkxxInfo.class, ftydwdkfkxxInfoListener).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        excelReader.finish();
        return ftydwdkfkxxInfoListener.getFtydwdkfkxxInfoList();
    }

    //贷款基础
    public static List<FtydwdkjcxxInfo> saxReadFtydwdkjcxxInfo(String pathFile) throws IOException {
        FtydwdkjcxxInfoListener ftydwdkjcxxInfoListener = new FtydwdkjcxxInfoListener();
        ExcelReader excelReader = EasyExcel.read(pathFile, FtydwdkjcxxInfo.class, ftydwdkjcxxInfoListener).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        excelReader.finish();
        return ftydwdkjcxxInfoListener.getFtydwdkjcxxInfoList();
    }

    //贷款余额
    public static List<FtydwdkyexxInfo> saxReadFtydwdkyexxInfo(String pathFile) throws IOException {
        FtydwdkyexxInfoListener ftydwdkyexxInfoListener = new FtydwdkyexxInfoListener();
        ExcelReader excelReader = EasyExcel.read(pathFile, FtydwdkyexxInfo.class, ftydwdkyexxInfoListener).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        excelReader.finish();
        return ftydwdkyexxInfoListener.getFtydwdkyexxInfoList();
    }

    public static List<JrjgfrxxInfo> saxReadJrjgfrxxInfo(String pathFile) throws IOException {
        JrjgfrxxInfoListener jrjgfrxxInfoListener = new JrjgfrxxInfoListener();
        ExcelReader excelReader = EasyExcel.read(pathFile, JrjgfrxxInfo.class, jrjgfrxxInfoListener).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        excelReader.finish();
        return jrjgfrxxInfoListener.getJrjgfrxxInfoList();
    }

    public static List<JrjgfzxxInfo> saxReadJrjgfzxxInfo(String pathFile) throws IOException {
        JrjgfzxxInfoListener jrjgfzxxInfoListener = new JrjgfzxxInfoListener();
        ExcelReader excelReader = EasyExcel.read(pathFile, JrjgfzxxInfo.class, jrjgfzxxInfoListener).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        excelReader.finish();
        return jrjgfzxxInfoListener.getJrjgfzxxInfoList();
    }

    //买入卖出
    public static List<MrfsmchgjcxxInfo> saxReadMrfsmchgjcxxInfo(String pathFile) throws IOException {
        MrfsmchgjcxxInfoListener mrfsmchgjcxxInfoListener = new MrfsmchgjcxxInfoListener();
        ExcelReader excelReader = EasyExcel.read(pathFile, MrfsmchgjcxxInfo.class, mrfsmchgjcxxInfoListener).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        excelReader.finish();
        return mrfsmchgjcxxInfoListener.getMrfsmchgjcxxInfoList();
    }

    //买入卖出
    public static List<MrfsmchgfsxxInfo> saxReadMrfsmchgfsxxInfo(String pathFile) throws IOException {
        MrfsmchgfsxxInfoListener mrfsmchgfsxxInfoListener = new MrfsmchgfsxxInfoListener();
        ExcelReader excelReader = EasyExcel.read(pathFile, MrfsmchgfsxxInfo.class, mrfsmchgfsxxInfoListener).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        excelReader.finish();
        return mrfsmchgfsxxInfoListener.getMrfsmchgfsxxInfoList();
    }

    //买入卖出
    public static List<MrfsmchgyexxInfo> saxReadMrfsmchgyexxInfo(String pathFile) throws IOException {
        MrfsmchgyexxInfoListener mrfsmchgyexxInfoListener = new MrfsmchgyexxInfoListener();
        ExcelReader excelReader = EasyExcel.read(pathFile, MrfsmchgyexxInfo.class, mrfsmchgyexxInfoListener).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        excelReader.finish();
        return mrfsmchgyexxInfoListener.getMrfsmchgyexxInfoList();
    }

    //同业存款发生
    public static List<TyckfsxxInfo> saxReadTyckfsxxInfo(String pathFile) throws IOException {
        TyckfsxxInfoListener tyckfsxxInfoListener = new TyckfsxxInfoListener();
        ExcelReader excelReader = EasyExcel.read(pathFile, TyckfsxxInfo.class, tyckfsxxInfoListener).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        excelReader.finish();
        return tyckfsxxInfoListener.getTyckfsxxInfoList();
    }

    //同业存款基础
    public static List<TyckjcxxInfo> saxReadTyckjcxxInfo(String pathFile) throws IOException {
        TyckjcxxInfoListener tyckjcxxInfoListener = new TyckjcxxInfoListener();
        ExcelReader excelReader = EasyExcel.read(pathFile, TyckjcxxInfo.class, tyckjcxxInfoListener).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        excelReader.finish();
        return tyckjcxxInfoListener.getTyckjcxxInfoList();
    }

    //同业存款余额
    public static List<TyckyexxInfo> saxReadTyckyexxInfo(String pathFile) throws IOException {
        TyckyexxInfoListener tyckyexxInfoListener = new TyckyexxInfoListener();
        ExcelReader excelReader = EasyExcel.read(pathFile, TyckyexxInfo.class, tyckyexxInfoListener).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        excelReader.finish();
        return tyckyexxInfoListener.getTyckyexxInfoList();
    }

    //委托贷款放款
    public static List<WtdkfkxxInfo> saxReadWtdkfkxxInfo(String pathFile) throws IOException {
        WtdkfkxxInfoListener wtdkfkxxInfoListener = new WtdkfkxxInfoListener();
        ExcelReader excelReader = EasyExcel.read(pathFile, WtdkfkxxInfo.class, wtdkfkxxInfoListener).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        excelReader.finish();
        return wtdkfkxxInfoListener.getWtdkfkxxInfoList();
    }

    //委托贷款基础
    public static List<WtdkjcxxInfo> saxReadWtdkjcxxInfo(String pathFile) throws IOException {
        WtdkjcxxInfoListener wtdkjcxxInfoListener = new WtdkjcxxInfoListener();
        ExcelReader excelReader = EasyExcel.read(pathFile, WtdkjcxxInfo.class, wtdkjcxxInfoListener).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        excelReader.finish();
        return wtdkjcxxInfoListener.getWtdkjcxxInfoList();
    }

    //委托贷款余额
    public static List<WtdkyexxInfo> saxReadWtdkyexxInfo(String pathFile) throws IOException {
        WtdkyexxInfoListener wtdkyexxInfoListener = new WtdkyexxInfoListener();
        ExcelReader excelReader = EasyExcel.read(pathFile, WtdkyexxInfo.class, wtdkyexxInfoListener).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        excelReader.finish();
        return wtdkyexxInfoListener.getWtdkyexxInfoList();
    }

    //票据贴现发生
    public static List<PjtxztxfsxxInfo> saxReadPjtxztxfsxxInfo(String pathFile) throws IOException {
        PjtxztxfsxxInfoListener pjtxztxfsxxInfoListener = new PjtxztxfsxxInfoListener();
        ExcelReader excelReader = EasyExcel.read(pathFile, PjtxztxfsxxInfo.class, pjtxztxfsxxInfoListener).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        excelReader.finish();
        return pjtxztxfsxxInfoListener.getPjtxztxfsxxInfoList();
    }

    //票据贴现基础
    public static List<PjtxztxjcxxInfo> saxReadPjtxztxjcxxInfo(String pathFile) throws IOException {
        PjtxztxjcxxInfoListener pjtxztxjcxxInfoListener = new PjtxztxjcxxInfoListener();
        ExcelReader excelReader = EasyExcel.read(pathFile, PjtxztxjcxxInfo.class, pjtxztxjcxxInfoListener).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        excelReader.finish();
        return pjtxztxjcxxInfoListener.getPjtxztxjcxxInfoList();
    }

    //票据贴现余额
    public static List<PjtxztxyexxInfo> saxReadPjtxztxyexxInfo(String pathFile) throws IOException {
        PjtxztxyexxInfoListener pjtxztxyexxInfoListener = new PjtxztxyexxInfoListener();
        ExcelReader excelReader = EasyExcel.read(pathFile, PjtxztxyexxInfo.class, pjtxztxyexxInfoListener).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        excelReader.finish();
        return pjtxztxyexxInfoListener.getPjtxztxyexxInfoList();
    }
}
