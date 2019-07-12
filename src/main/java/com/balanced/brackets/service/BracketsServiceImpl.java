package com.balanced.brackets.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * BracketsServiceImpl
 */
@Service
public class BracketsServiceImpl implements BracketsService{

    private static final String BRACKETS_OPEN = "{[(";

    private static final String BRACKETS_CLOSE = "}])";

    @Override
    public boolean isValid(String sequence) {
        char[] characteres = sequence.toCharArray();

        List<String> opened = new ArrayList<>();

        for (char character : characteres) {
            String value = String.valueOf(character);
            if (isBracketsOpen(value)){
                opened.add(value);
            } else if (isBracketsClose(value)){
                if(opened.isEmpty()){
                    return false;
                }
                String associated = getBracketAssociated(value);
                String lastOpen = opened.get(opened.size() - 1);
                if(lastOpen.equals(associated)){
                    opened.remove(opened.size()-1);
                } else {
                    return false;
                }
            }
        }

        if(opened.isEmpty()){
            return true;
        }

        return false;
    }

    private boolean isBracketsOpen(String value) {
        return BRACKETS_OPEN.contains(value);
    }

    private boolean isBracketsClose(String value) {
        return BRACKETS_CLOSE.contains(value);
    }

    private String getBracketAssociated(String value){
        int index = BRACKETS_CLOSE.indexOf(value);
        return BRACKETS_OPEN.substring(index, index + 1); 
    }

    
}