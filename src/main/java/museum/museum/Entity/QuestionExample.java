package museum.museum.Entity;

import java.util.ArrayList;
import java.util.List;

public class QuestionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QuestionExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andQIdIsNull() {
            addCriterion("q_id is null");
            return (Criteria) this;
        }

        public Criteria andQIdIsNotNull() {
            addCriterion("q_id is not null");
            return (Criteria) this;
        }

        public Criteria andQIdEqualTo(Long value) {
            addCriterion("q_id =", value, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdNotEqualTo(Long value) {
            addCriterion("q_id <>", value, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdGreaterThan(Long value) {
            addCriterion("q_id >", value, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdGreaterThanOrEqualTo(Long value) {
            addCriterion("q_id >=", value, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdLessThan(Long value) {
            addCriterion("q_id <", value, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdLessThanOrEqualTo(Long value) {
            addCriterion("q_id <=", value, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdIn(List<Long> values) {
            addCriterion("q_id in", values, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdNotIn(List<Long> values) {
            addCriterion("q_id not in", values, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdBetween(Long value1, Long value2) {
            addCriterion("q_id between", value1, value2, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdNotBetween(Long value1, Long value2) {
            addCriterion("q_id not between", value1, value2, "qId");
            return (Criteria) this;
        }

        public Criteria andKindIsNull() {
            addCriterion("kind is null");
            return (Criteria) this;
        }

        public Criteria andKindIsNotNull() {
            addCriterion("kind is not null");
            return (Criteria) this;
        }

        public Criteria andKindEqualTo(String value) {
            addCriterion("kind =", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindNotEqualTo(String value) {
            addCriterion("kind <>", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindGreaterThan(String value) {
            addCriterion("kind >", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindGreaterThanOrEqualTo(String value) {
            addCriterion("kind >=", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindLessThan(String value) {
            addCriterion("kind <", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindLessThanOrEqualTo(String value) {
            addCriterion("kind <=", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindLike(String value) {
            addCriterion("kind like", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindNotLike(String value) {
            addCriterion("kind not like", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindIn(List<String> values) {
            addCriterion("kind in", values, "kind");
            return (Criteria) this;
        }

        public Criteria andKindNotIn(List<String> values) {
            addCriterion("kind not in", values, "kind");
            return (Criteria) this;
        }

        public Criteria andKindBetween(String value1, String value2) {
            addCriterion("kind between", value1, value2, "kind");
            return (Criteria) this;
        }

        public Criteria andKindNotBetween(String value1, String value2) {
            addCriterion("kind not between", value1, value2, "kind");
            return (Criteria) this;
        }

        public Criteria andDegreeIsNull() {
            addCriterion("degree is null");
            return (Criteria) this;
        }

        public Criteria andDegreeIsNotNull() {
            addCriterion("degree is not null");
            return (Criteria) this;
        }

        public Criteria andDegreeEqualTo(Integer value) {
            addCriterion("degree =", value, "degree");
            return (Criteria) this;
        }

        public Criteria andDegreeNotEqualTo(Integer value) {
            addCriterion("degree <>", value, "degree");
            return (Criteria) this;
        }

        public Criteria andDegreeGreaterThan(Integer value) {
            addCriterion("degree >", value, "degree");
            return (Criteria) this;
        }

        public Criteria andDegreeGreaterThanOrEqualTo(Integer value) {
            addCriterion("degree >=", value, "degree");
            return (Criteria) this;
        }

        public Criteria andDegreeLessThan(Integer value) {
            addCriterion("degree <", value, "degree");
            return (Criteria) this;
        }

        public Criteria andDegreeLessThanOrEqualTo(Integer value) {
            addCriterion("degree <=", value, "degree");
            return (Criteria) this;
        }

        public Criteria andDegreeIn(List<Integer> values) {
            addCriterion("degree in", values, "degree");
            return (Criteria) this;
        }

        public Criteria andDegreeNotIn(List<Integer> values) {
            addCriterion("degree not in", values, "degree");
            return (Criteria) this;
        }

        public Criteria andDegreeBetween(Integer value1, Integer value2) {
            addCriterion("degree between", value1, value2, "degree");
            return (Criteria) this;
        }

        public Criteria andDegreeNotBetween(Integer value1, Integer value2) {
            addCriterion("degree not between", value1, value2, "degree");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentImageIsNull() {
            addCriterion("content_image is null");
            return (Criteria) this;
        }

        public Criteria andContentImageIsNotNull() {
            addCriterion("content_image is not null");
            return (Criteria) this;
        }

        public Criteria andContentImageEqualTo(String value) {
            addCriterion("content_image =", value, "contentImage");
            return (Criteria) this;
        }

        public Criteria andContentImageNotEqualTo(String value) {
            addCriterion("content_image <>", value, "contentImage");
            return (Criteria) this;
        }

        public Criteria andContentImageGreaterThan(String value) {
            addCriterion("content_image >", value, "contentImage");
            return (Criteria) this;
        }

        public Criteria andContentImageGreaterThanOrEqualTo(String value) {
            addCriterion("content_image >=", value, "contentImage");
            return (Criteria) this;
        }

        public Criteria andContentImageLessThan(String value) {
            addCriterion("content_image <", value, "contentImage");
            return (Criteria) this;
        }

        public Criteria andContentImageLessThanOrEqualTo(String value) {
            addCriterion("content_image <=", value, "contentImage");
            return (Criteria) this;
        }

        public Criteria andContentImageLike(String value) {
            addCriterion("content_image like", value, "contentImage");
            return (Criteria) this;
        }

        public Criteria andContentImageNotLike(String value) {
            addCriterion("content_image not like", value, "contentImage");
            return (Criteria) this;
        }

        public Criteria andContentImageIn(List<String> values) {
            addCriterion("content_image in", values, "contentImage");
            return (Criteria) this;
        }

        public Criteria andContentImageNotIn(List<String> values) {
            addCriterion("content_image not in", values, "contentImage");
            return (Criteria) this;
        }

        public Criteria andContentImageBetween(String value1, String value2) {
            addCriterion("content_image between", value1, value2, "contentImage");
            return (Criteria) this;
        }

        public Criteria andContentImageNotBetween(String value1, String value2) {
            addCriterion("content_image not between", value1, value2, "contentImage");
            return (Criteria) this;
        }

        public Criteria andOptionAIsNull() {
            addCriterion("option_a is null");
            return (Criteria) this;
        }

        public Criteria andOptionAIsNotNull() {
            addCriterion("option_a is not null");
            return (Criteria) this;
        }

        public Criteria andOptionAEqualTo(String value) {
            addCriterion("option_a =", value, "optionA");
            return (Criteria) this;
        }

        public Criteria andOptionANotEqualTo(String value) {
            addCriterion("option_a <>", value, "optionA");
            return (Criteria) this;
        }

        public Criteria andOptionAGreaterThan(String value) {
            addCriterion("option_a >", value, "optionA");
            return (Criteria) this;
        }

        public Criteria andOptionAGreaterThanOrEqualTo(String value) {
            addCriterion("option_a >=", value, "optionA");
            return (Criteria) this;
        }

        public Criteria andOptionALessThan(String value) {
            addCriterion("option_a <", value, "optionA");
            return (Criteria) this;
        }

        public Criteria andOptionALessThanOrEqualTo(String value) {
            addCriterion("option_a <=", value, "optionA");
            return (Criteria) this;
        }

        public Criteria andOptionALike(String value) {
            addCriterion("option_a like", value, "optionA");
            return (Criteria) this;
        }

        public Criteria andOptionANotLike(String value) {
            addCriterion("option_a not like", value, "optionA");
            return (Criteria) this;
        }

        public Criteria andOptionAIn(List<String> values) {
            addCriterion("option_a in", values, "optionA");
            return (Criteria) this;
        }

        public Criteria andOptionANotIn(List<String> values) {
            addCriterion("option_a not in", values, "optionA");
            return (Criteria) this;
        }

        public Criteria andOptionABetween(String value1, String value2) {
            addCriterion("option_a between", value1, value2, "optionA");
            return (Criteria) this;
        }

        public Criteria andOptionANotBetween(String value1, String value2) {
            addCriterion("option_a not between", value1, value2, "optionA");
            return (Criteria) this;
        }

        public Criteria andOptionBIsNull() {
            addCriterion("option_b is null");
            return (Criteria) this;
        }

        public Criteria andOptionBIsNotNull() {
            addCriterion("option_b is not null");
            return (Criteria) this;
        }

        public Criteria andOptionBEqualTo(String value) {
            addCriterion("option_b =", value, "optionB");
            return (Criteria) this;
        }

        public Criteria andOptionBNotEqualTo(String value) {
            addCriterion("option_b <>", value, "optionB");
            return (Criteria) this;
        }

        public Criteria andOptionBGreaterThan(String value) {
            addCriterion("option_b >", value, "optionB");
            return (Criteria) this;
        }

        public Criteria andOptionBGreaterThanOrEqualTo(String value) {
            addCriterion("option_b >=", value, "optionB");
            return (Criteria) this;
        }

        public Criteria andOptionBLessThan(String value) {
            addCriterion("option_b <", value, "optionB");
            return (Criteria) this;
        }

        public Criteria andOptionBLessThanOrEqualTo(String value) {
            addCriterion("option_b <=", value, "optionB");
            return (Criteria) this;
        }

        public Criteria andOptionBLike(String value) {
            addCriterion("option_b like", value, "optionB");
            return (Criteria) this;
        }

        public Criteria andOptionBNotLike(String value) {
            addCriterion("option_b not like", value, "optionB");
            return (Criteria) this;
        }

        public Criteria andOptionBIn(List<String> values) {
            addCriterion("option_b in", values, "optionB");
            return (Criteria) this;
        }

        public Criteria andOptionBNotIn(List<String> values) {
            addCriterion("option_b not in", values, "optionB");
            return (Criteria) this;
        }

        public Criteria andOptionBBetween(String value1, String value2) {
            addCriterion("option_b between", value1, value2, "optionB");
            return (Criteria) this;
        }

        public Criteria andOptionBNotBetween(String value1, String value2) {
            addCriterion("option_b not between", value1, value2, "optionB");
            return (Criteria) this;
        }

        public Criteria andOptionCIsNull() {
            addCriterion("option_c is null");
            return (Criteria) this;
        }

        public Criteria andOptionCIsNotNull() {
            addCriterion("option_c is not null");
            return (Criteria) this;
        }

        public Criteria andOptionCEqualTo(String value) {
            addCriterion("option_c =", value, "optionC");
            return (Criteria) this;
        }

        public Criteria andOptionCNotEqualTo(String value) {
            addCriterion("option_c <>", value, "optionC");
            return (Criteria) this;
        }

        public Criteria andOptionCGreaterThan(String value) {
            addCriterion("option_c >", value, "optionC");
            return (Criteria) this;
        }

        public Criteria andOptionCGreaterThanOrEqualTo(String value) {
            addCriterion("option_c >=", value, "optionC");
            return (Criteria) this;
        }

        public Criteria andOptionCLessThan(String value) {
            addCriterion("option_c <", value, "optionC");
            return (Criteria) this;
        }

        public Criteria andOptionCLessThanOrEqualTo(String value) {
            addCriterion("option_c <=", value, "optionC");
            return (Criteria) this;
        }

        public Criteria andOptionCLike(String value) {
            addCriterion("option_c like", value, "optionC");
            return (Criteria) this;
        }

        public Criteria andOptionCNotLike(String value) {
            addCriterion("option_c not like", value, "optionC");
            return (Criteria) this;
        }

        public Criteria andOptionCIn(List<String> values) {
            addCriterion("option_c in", values, "optionC");
            return (Criteria) this;
        }

        public Criteria andOptionCNotIn(List<String> values) {
            addCriterion("option_c not in", values, "optionC");
            return (Criteria) this;
        }

        public Criteria andOptionCBetween(String value1, String value2) {
            addCriterion("option_c between", value1, value2, "optionC");
            return (Criteria) this;
        }

        public Criteria andOptionCNotBetween(String value1, String value2) {
            addCriterion("option_c not between", value1, value2, "optionC");
            return (Criteria) this;
        }

        public Criteria andOptionAImageIsNull() {
            addCriterion("option_a_image is null");
            return (Criteria) this;
        }

        public Criteria andOptionAImageIsNotNull() {
            addCriterion("option_a_image is not null");
            return (Criteria) this;
        }

        public Criteria andOptionAImageEqualTo(String value) {
            addCriterion("option_a_image =", value, "optionAImage");
            return (Criteria) this;
        }

        public Criteria andOptionAImageNotEqualTo(String value) {
            addCriterion("option_a_image <>", value, "optionAImage");
            return (Criteria) this;
        }

        public Criteria andOptionAImageGreaterThan(String value) {
            addCriterion("option_a_image >", value, "optionAImage");
            return (Criteria) this;
        }

        public Criteria andOptionAImageGreaterThanOrEqualTo(String value) {
            addCriterion("option_a_image >=", value, "optionAImage");
            return (Criteria) this;
        }

        public Criteria andOptionAImageLessThan(String value) {
            addCriterion("option_a_image <", value, "optionAImage");
            return (Criteria) this;
        }

        public Criteria andOptionAImageLessThanOrEqualTo(String value) {
            addCriterion("option_a_image <=", value, "optionAImage");
            return (Criteria) this;
        }

        public Criteria andOptionAImageLike(String value) {
            addCriterion("option_a_image like", value, "optionAImage");
            return (Criteria) this;
        }

        public Criteria andOptionAImageNotLike(String value) {
            addCriterion("option_a_image not like", value, "optionAImage");
            return (Criteria) this;
        }

        public Criteria andOptionAImageIn(List<String> values) {
            addCriterion("option_a_image in", values, "optionAImage");
            return (Criteria) this;
        }

        public Criteria andOptionAImageNotIn(List<String> values) {
            addCriterion("option_a_image not in", values, "optionAImage");
            return (Criteria) this;
        }

        public Criteria andOptionAImageBetween(String value1, String value2) {
            addCriterion("option_a_image between", value1, value2, "optionAImage");
            return (Criteria) this;
        }

        public Criteria andOptionAImageNotBetween(String value1, String value2) {
            addCriterion("option_a_image not between", value1, value2, "optionAImage");
            return (Criteria) this;
        }

        public Criteria andOptionBImageIsNull() {
            addCriterion("option_b_image is null");
            return (Criteria) this;
        }

        public Criteria andOptionBImageIsNotNull() {
            addCriterion("option_b_image is not null");
            return (Criteria) this;
        }

        public Criteria andOptionBImageEqualTo(String value) {
            addCriterion("option_b_image =", value, "optionBImage");
            return (Criteria) this;
        }

        public Criteria andOptionBImageNotEqualTo(String value) {
            addCriterion("option_b_image <>", value, "optionBImage");
            return (Criteria) this;
        }

        public Criteria andOptionBImageGreaterThan(String value) {
            addCriterion("option_b_image >", value, "optionBImage");
            return (Criteria) this;
        }

        public Criteria andOptionBImageGreaterThanOrEqualTo(String value) {
            addCriterion("option_b_image >=", value, "optionBImage");
            return (Criteria) this;
        }

        public Criteria andOptionBImageLessThan(String value) {
            addCriterion("option_b_image <", value, "optionBImage");
            return (Criteria) this;
        }

        public Criteria andOptionBImageLessThanOrEqualTo(String value) {
            addCriterion("option_b_image <=", value, "optionBImage");
            return (Criteria) this;
        }

        public Criteria andOptionBImageLike(String value) {
            addCriterion("option_b_image like", value, "optionBImage");
            return (Criteria) this;
        }

        public Criteria andOptionBImageNotLike(String value) {
            addCriterion("option_b_image not like", value, "optionBImage");
            return (Criteria) this;
        }

        public Criteria andOptionBImageIn(List<String> values) {
            addCriterion("option_b_image in", values, "optionBImage");
            return (Criteria) this;
        }

        public Criteria andOptionBImageNotIn(List<String> values) {
            addCriterion("option_b_image not in", values, "optionBImage");
            return (Criteria) this;
        }

        public Criteria andOptionBImageBetween(String value1, String value2) {
            addCriterion("option_b_image between", value1, value2, "optionBImage");
            return (Criteria) this;
        }

        public Criteria andOptionBImageNotBetween(String value1, String value2) {
            addCriterion("option_b_image not between", value1, value2, "optionBImage");
            return (Criteria) this;
        }

        public Criteria andOptionCImageIsNull() {
            addCriterion("option_c_image is null");
            return (Criteria) this;
        }

        public Criteria andOptionCImageIsNotNull() {
            addCriterion("option_c_image is not null");
            return (Criteria) this;
        }

        public Criteria andOptionCImageEqualTo(String value) {
            addCriterion("option_c_image =", value, "optionCImage");
            return (Criteria) this;
        }

        public Criteria andOptionCImageNotEqualTo(String value) {
            addCriterion("option_c_image <>", value, "optionCImage");
            return (Criteria) this;
        }

        public Criteria andOptionCImageGreaterThan(String value) {
            addCriterion("option_c_image >", value, "optionCImage");
            return (Criteria) this;
        }

        public Criteria andOptionCImageGreaterThanOrEqualTo(String value) {
            addCriterion("option_c_image >=", value, "optionCImage");
            return (Criteria) this;
        }

        public Criteria andOptionCImageLessThan(String value) {
            addCriterion("option_c_image <", value, "optionCImage");
            return (Criteria) this;
        }

        public Criteria andOptionCImageLessThanOrEqualTo(String value) {
            addCriterion("option_c_image <=", value, "optionCImage");
            return (Criteria) this;
        }

        public Criteria andOptionCImageLike(String value) {
            addCriterion("option_c_image like", value, "optionCImage");
            return (Criteria) this;
        }

        public Criteria andOptionCImageNotLike(String value) {
            addCriterion("option_c_image not like", value, "optionCImage");
            return (Criteria) this;
        }

        public Criteria andOptionCImageIn(List<String> values) {
            addCriterion("option_c_image in", values, "optionCImage");
            return (Criteria) this;
        }

        public Criteria andOptionCImageNotIn(List<String> values) {
            addCriterion("option_c_image not in", values, "optionCImage");
            return (Criteria) this;
        }

        public Criteria andOptionCImageBetween(String value1, String value2) {
            addCriterion("option_c_image between", value1, value2, "optionCImage");
            return (Criteria) this;
        }

        public Criteria andOptionCImageNotBetween(String value1, String value2) {
            addCriterion("option_c_image not between", value1, value2, "optionCImage");
            return (Criteria) this;
        }

        public Criteria andAnswerIsNull() {
            addCriterion("answer is null");
            return (Criteria) this;
        }

        public Criteria andAnswerIsNotNull() {
            addCriterion("answer is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerEqualTo(String value) {
            addCriterion("answer =", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotEqualTo(String value) {
            addCriterion("answer <>", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerGreaterThan(String value) {
            addCriterion("answer >", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerGreaterThanOrEqualTo(String value) {
            addCriterion("answer >=", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLessThan(String value) {
            addCriterion("answer <", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLessThanOrEqualTo(String value) {
            addCriterion("answer <=", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLike(String value) {
            addCriterion("answer like", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotLike(String value) {
            addCriterion("answer not like", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerIn(List<String> values) {
            addCriterion("answer in", values, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotIn(List<String> values) {
            addCriterion("answer not in", values, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerBetween(String value1, String value2) {
            addCriterion("answer between", value1, value2, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotBetween(String value1, String value2) {
            addCriterion("answer not between", value1, value2, "answer");
            return (Criteria) this;
        }

        public Criteria andAnalysisIsNull() {
            addCriterion("analysis is null");
            return (Criteria) this;
        }

        public Criteria andAnalysisIsNotNull() {
            addCriterion("analysis is not null");
            return (Criteria) this;
        }

        public Criteria andAnalysisEqualTo(String value) {
            addCriterion("analysis =", value, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisNotEqualTo(String value) {
            addCriterion("analysis <>", value, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisGreaterThan(String value) {
            addCriterion("analysis >", value, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisGreaterThanOrEqualTo(String value) {
            addCriterion("analysis >=", value, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisLessThan(String value) {
            addCriterion("analysis <", value, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisLessThanOrEqualTo(String value) {
            addCriterion("analysis <=", value, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisLike(String value) {
            addCriterion("analysis like", value, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisNotLike(String value) {
            addCriterion("analysis not like", value, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisIn(List<String> values) {
            addCriterion("analysis in", values, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisNotIn(List<String> values) {
            addCriterion("analysis not in", values, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisBetween(String value1, String value2) {
            addCriterion("analysis between", value1, value2, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisNotBetween(String value1, String value2) {
            addCriterion("analysis not between", value1, value2, "analysis");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}