package com.sunpeifu.data_structure.java8.XingWeiCanShuHua.HuanRaoZhiXing;

import java.io.BufferedReader;
import java.io.FileReader;

@FunctionalInterface
public interface BufferReaderProcessor {

    String processFile(BufferedReader br) throws Exception;



}
