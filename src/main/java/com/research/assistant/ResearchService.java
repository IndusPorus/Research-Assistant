package com.research.assistant;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ResearchService {

    public String processContent(ResearchRequest request){
        //build the prompt
        String prompt= buildPrompt(request) ;
        //Query the AI API Model
        Map<String, Object> requestBody = Map.of(
                "contents", new Object[]{
                        Map.of("parts", new Object[]{
                                Map.of("text", prompt)
                        })
                }
        );

        //Parse the Response
        // Return the Response

    }

    private String buildPrompt(ResearchRequest request){
        StringBuilder prompt = new StringBuilder();
        switch (request.getOperation()){
            case "summarize":
                prompt.append("Provide a clear and concise summary of the following text in few sentences:\n\n");
                break;
            case "suggest":
                prompt.append("Based on the following content: suggest related topics and further reading. Format the response with clear headings and bullet points:\n\n");
                break;
            default:
                throw new IllegalArgumentException("Unknown Operation: " +request.getOperation());
        }
    prompt.append(request.getContent());
        return prompt.toString();
    }
}
