package museum.museum.Entity;

import java.util.ArrayList;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andAvatarIsNull() {
            addCriterion("avatar is null");
            return (Criteria) this;
        }

        public Criteria andAvatarIsNotNull() {
            addCriterion("avatar is not null");
            return (Criteria) this;
        }

        public Criteria andAvatarEqualTo(String value) {
            addCriterion("avatar =", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotEqualTo(String value) {
            addCriterion("avatar <>", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarGreaterThan(String value) {
            addCriterion("avatar >", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarGreaterThanOrEqualTo(String value) {
            addCriterion("avatar >=", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLessThan(String value) {
            addCriterion("avatar <", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLessThanOrEqualTo(String value) {
            addCriterion("avatar <=", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLike(String value) {
            addCriterion("avatar like", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotLike(String value) {
            addCriterion("avatar not like", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarIn(List<String> values) {
            addCriterion("avatar in", values, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotIn(List<String> values) {
            addCriterion("avatar not in", values, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarBetween(String value1, String value2) {
            addCriterion("avatar between", value1, value2, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotBetween(String value1, String value2) {
            addCriterion("avatar not between", value1, value2, "avatar");
            return (Criteria) this;
        }

        public Criteria andQsFinishIsNull() {
            addCriterion("qs_finish is null");
            return (Criteria) this;
        }

        public Criteria andQsFinishIsNotNull() {
            addCriterion("qs_finish is not null");
            return (Criteria) this;
        }

        public Criteria andQsFinishEqualTo(Integer value) {
            addCriterion("qs_finish =", value, "qsFinish");
            return (Criteria) this;
        }

        public Criteria andQsFinishNotEqualTo(Integer value) {
            addCriterion("qs_finish <>", value, "qsFinish");
            return (Criteria) this;
        }

        public Criteria andQsFinishGreaterThan(Integer value) {
            addCriterion("qs_finish >", value, "qsFinish");
            return (Criteria) this;
        }

        public Criteria andQsFinishGreaterThanOrEqualTo(Integer value) {
            addCriterion("qs_finish >=", value, "qsFinish");
            return (Criteria) this;
        }

        public Criteria andQsFinishLessThan(Integer value) {
            addCriterion("qs_finish <", value, "qsFinish");
            return (Criteria) this;
        }

        public Criteria andQsFinishLessThanOrEqualTo(Integer value) {
            addCriterion("qs_finish <=", value, "qsFinish");
            return (Criteria) this;
        }

        public Criteria andQsFinishIn(List<Integer> values) {
            addCriterion("qs_finish in", values, "qsFinish");
            return (Criteria) this;
        }

        public Criteria andQsFinishNotIn(List<Integer> values) {
            addCriterion("qs_finish not in", values, "qsFinish");
            return (Criteria) this;
        }

        public Criteria andQsFinishBetween(Integer value1, Integer value2) {
            addCriterion("qs_finish between", value1, value2, "qsFinish");
            return (Criteria) this;
        }

        public Criteria andQsFinishNotBetween(Integer value1, Integer value2) {
            addCriterion("qs_finish not between", value1, value2, "qsFinish");
            return (Criteria) this;
        }

        public Criteria andStarletIsNull() {
            addCriterion("starlet is null");
            return (Criteria) this;
        }

        public Criteria andStarletIsNotNull() {
            addCriterion("starlet is not null");
            return (Criteria) this;
        }

        public Criteria andStarletEqualTo(Long value) {
            addCriterion("starlet =", value, "starlet");
            return (Criteria) this;
        }

        public Criteria andStarletNotEqualTo(Long value) {
            addCriterion("starlet <>", value, "starlet");
            return (Criteria) this;
        }

        public Criteria andStarletGreaterThan(Long value) {
            addCriterion("starlet >", value, "starlet");
            return (Criteria) this;
        }

        public Criteria andStarletGreaterThanOrEqualTo(Long value) {
            addCriterion("starlet >=", value, "starlet");
            return (Criteria) this;
        }

        public Criteria andStarletLessThan(Long value) {
            addCriterion("starlet <", value, "starlet");
            return (Criteria) this;
        }

        public Criteria andStarletLessThanOrEqualTo(Long value) {
            addCriterion("starlet <=", value, "starlet");
            return (Criteria) this;
        }

        public Criteria andStarletIn(List<Long> values) {
            addCriterion("starlet in", values, "starlet");
            return (Criteria) this;
        }

        public Criteria andStarletNotIn(List<Long> values) {
            addCriterion("starlet not in", values, "starlet");
            return (Criteria) this;
        }

        public Criteria andStarletBetween(Long value1, Long value2) {
            addCriterion("starlet between", value1, value2, "starlet");
            return (Criteria) this;
        }

        public Criteria andStarletNotBetween(Long value1, Long value2) {
            addCriterion("starlet not between", value1, value2, "starlet");
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