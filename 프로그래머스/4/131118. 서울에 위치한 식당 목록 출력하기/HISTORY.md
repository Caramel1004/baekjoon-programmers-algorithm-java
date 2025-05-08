- LEFT JOIN 하여 rest_info 테이블의 식당 리뷰를 조회
- 리뷰가 없는 식당은 restInfo 테이블의 레코드에대한 restReview 테이블에 해당하는 컬럼 값들이 null로 조회
- score 통계 계산 시, 리뷰 없는 식당은 0으로 처리

```
SELECT
    ri.rest_id AS rest_id,
    ri.rest_name AS rest_name,
    ri.food_type AS food_type,
    ri.favorites AS favorites,
    ri.address AS address,
    COALESCE(ROUND(AVG(rr.review_score), 2), 0) AS score
FROM
    REST_INFO ri
INNER JOIN
    REST_REVIEW rr
ON ri.rest_id = rr.rest_id
WHERE
    ri.address LIKE '서울%'
GROUP BY
    ri.rest_id
ORDER BY
    score DESC,
    favorites DESC;
```
- SQL문 실행 후 결과 확인

```
rest_id	rest_name	food_type	favorites	address	score
00001	은돼지식당	한식	734	서울특별시 중구 다산로 149	5.00
00002	하이가쯔네	일식	112	서울시 중구 신당동 375-21	4.50
00004	스시사카우스	일식	230	서울시 강남구 신사동 627-27	4.29
00003	따띠따띠뜨	양식	102	서울시 강남구 신사동 627-3 1F	4.00
00008	애플우스	분식	151	서울특별시 동작구 동작대로27다길 29 2F	0.00
00005	코슌스	일식	123	서울특별시 강남구 언주로153길	0.00
```

- 내가 예상한대로 서울에대한 조회 데이터에 대해서 리뷰가 없는 식당은 0.00으로 잘 처리되어 조회
- 엥? 근데 답이 틀렸대....
- 처음에는 이해가 안갔음
- 혹시 몰라서 리뷰가 없는 식당은 애초에 조회가 안되어야하나?
- 그래서 INNER JOIN으로 변경하여 제출 시도

```
SELECT
    ri.rest_id AS rest_id,
    ri.rest_name AS rest_name,
    ri.food_type AS food_type,
    ri.favorites AS favorites,
    ri.address AS address,
    COALESCE(ROUND(AVG(rr.review_score), 2), 0) AS score
FROM
    REST_INFO ri
INNER JOIN
    REST_REVIEW rr
ON ri.rest_id = rr.rest_id
WHERE
    ri.address LIKE '서울%'
GROUP BY
    ri.rest_id
ORDER BY
    score DESC,
    favorites DESC;
```

```
rest_id	rest_name	food_type	favorites	address	score
00001	은돼지식당	한식	734	서울특별시 중구 다산로 149	5.00
00002	하이가쯔네	일식	112	서울시 중구 신당동 375-21	4.50
00004	스시사카우스	일식	230	서울시 강남구 신사동 627-27	4.29
00003	따띠따띠뜨	양식	102	서울시 강남구 신사동 627-3 1F	4.00
```

- 정답.
- 문제에서 리뷰가 없는 식당은 따로 처리 요구 사항이 추가되어있으면 좋을 것 같습니다.
- 아니면 조회 처리 안하도록 조건 사항에 추가되어야할 것 같습니다.
