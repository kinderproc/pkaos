package com.algon.pkaos.service;

public interface NickGeneratorService {

    String generateNick();

    String generateNick(String character, String appearance, String name);
}