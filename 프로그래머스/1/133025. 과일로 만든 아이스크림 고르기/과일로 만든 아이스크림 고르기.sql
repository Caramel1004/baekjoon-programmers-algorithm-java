-- 코드를 입력하세요
# FIRST_HALF: 아이스크림 가게 상반기 주문 정보 테이블
#  - SHIPMENT_ID: 출하 번호
#  - FLAVOR: 아이스크림 맛 (PK)
#  - TOTAL_ORDER: 총 주문량
# ICECREAM_INFO: 아이스크림 성분 정보 테이블
#  - FLAVOR: 아이스크림 맛 (FK)
#  - INGREDIENT_TYPE: 성분
#      - sugar_based 설탕
#      - fruit_based 과일
SELECT
    i.FLAVOR
FROM
    FIRST_HALF fh
INNER JOIN
    ICECREAM_INFO i ON fh.FLAVOR = i.FLAVOR
WHERE
    fh.TOTAL_ORDER > 3000 
    AND i.INGREDIENT_TYPE = 'fruit_based'
ORDER BY
    fh.TOTAL_ORDER DESC