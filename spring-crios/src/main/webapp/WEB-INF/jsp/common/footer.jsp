<c:forTokens items="${specificsJS}" delims="," var="varJs">
    <script src="${resourcesUrl}js/${varJs}"></script>
</c:forTokens>