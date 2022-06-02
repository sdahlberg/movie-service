## Welcome to GitHub Pages

You can use the [editor on GitHub](https://github.com/sdahlberg/movie-service/edit/gh-pages/index.md) to maintain and preview the content for your website in Markdown files.

Whenever you commit to this repository, GitHub Pages will run [Jekyll](https://jekyllrb.com/) to rebuild the pages in your site, from the content in your Markdown files.

### Markdown

Markdown is a lightweight and easy-to-use syntax for styling your writing. It includes conventions for


```markdown
Syntax highlighted code block

# Header 1
## Header 2
### Header 3

- Bulleted
- List

1. Numbered
2. List

**Bold** and _Italic_ and `Code` text

[Link](url) and ![Image](src)
```

For more details see [Basic writing and formatting syntax](https://docs.github.com/en/github/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax).

### Jekyll Themes

Your Pages site will use the layout and styles from the Jekyll theme you have selected in your [repository settings](https://github.com/sdahlberg/movie-service/settings/pages). The name of this theme is saved in the Jekyll `_config.yml` configuration file.

### Support or Contact

Having trouble with Pages? Check out our [documentation](https://docs.github.com/categories/github-pages-basics/) or [contact support](https://support.github.com/contact) and we’ll help you sort it out.

Random stukje java:
```java
    @Bean
    @Override
    protected KeycloakAuthenticationProcessingFilter keycloakAuthenticationProcessingFilter() throws Exception {
        RequestMatcher requestMatcher =
                new OrRequestMatcher(
                        new AntPathRequestMatcher("/sso/login"),
                        new QueryParamPresenceRequestMatcher(OAuth2Constants.ACCESS_TOKEN),
                        // We're providing our own authorization header matcher
                        new IgnoreKeycloakProcessingFilterRequestMatcher()
                );
        return new KeycloakAuthenticationProcessingFilter(authenticationManagerBean(), requestMatcher);
    }
```
