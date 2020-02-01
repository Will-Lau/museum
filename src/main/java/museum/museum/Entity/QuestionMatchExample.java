package museum.museum.Entity;

import java.util.ArrayList;
import java.util.List;

public class QuestionMatchExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QuestionMatchExample() {
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

        public Criteria andQsIdIsNull() {
            addCriterion("qs_id is null");
            return (Criteria) this;
        }

        public Criteria andQsIdIsNotNull() {
            addCriterion("qs_id is not null");
            return (Criteria) this;
        }

        public Criteria andQsIdEqualTo(Long value) {
            addCriterion("qs_id =", value, "qsId");
            return (Criteria) this;
        }

        public Criteria andQsIdNotEqualTo(Long value) {
            addCriterion("qs_id <>", value, "qsId");
            return (Criteria) this;
        }

        public Criteria andQsIdGreaterThan(Long value) {
            addCriterion("qs_id >", value, "qsId");
            return (Criteria) this;
        }

        public Criteria andQsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("qs_id >=", value, "qsId");
            return (Criteria) this;
        }

        public Criteria andQsIdLessThan(Long value) {
            addCriterion("qs_id <", value, "qsId");
            return (Criteria) this;
        }

        public Criteria andQsIdLessThanOrEqualTo(Long value) {
            addCriterion("qs_id <=", value, "qsId");
            return (Criteria) this;
        }

        public Criteria andQsIdIn(List<Long> values) {
            addCriterion("qs_id in", values, "qsId");
            return (Criteria) this;
        }

        public Criteria andQsIdNotIn(List<Long> values) {
            addCriterion("qs_id not in", values, "qsId");
            return (Criteria) this;
        }

        public Criteria andQsIdBetween(Long value1, Long value2) {
            addCriterion("qs_id between", value1, value2, "qsId");
            return (Criteria) this;
        }

        public Criteria andQsIdNotBetween(Long value1, Long value2) {
            addCriterion("qs_id not between", value1, value2, "qsId");
            return (Criteria) this;
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

        public Criteria andUserAnswerIsNull() {
            addCriterion("user_answer is null");
            return (Criteria) this;
        }

        public Criteria andUserAnswerIsNotNull() {
            addCriterion("user_answer is not null");
            return (Criteria) this;
        }

        public Criteria andUserAnswerEqualTo(String value) {
            addCriterion("user_answer =", value, "userAnswer");
            return (Criteria) this;
        }

        public Criteria andUserAnswerNotEqualTo(String value) {
            addCriterion("user_answer <>", value, "userAnswer");
            return (Criteria) this;
        }

        public Criteria andUserAnswerGreaterThan(String value) {
            addCriterion("user_answer >", value, "userAnswer");
            return (Criteria) this;
        }

        public Criteria andUserAnswerGreaterThanOrEqualTo(String value) {
            addCriterion("user_answer >=", value, "userAnswer");
            return (Criteria) this;
        }

        public Criteria andUserAnswerLessThan(String value) {
            addCriterion("user_answer <", value, "userAnswer");
            return (Criteria) this;
        }

        public Criteria andUserAnswerLessThanOrEqualTo(String value) {
            addCriterion("user_answer <=", value, "userAnswer");
            return (Criteria) this;
        }

        public Criteria andUserAnswerLike(String value) {
            addCriterion("user_answer like", value, "userAnswer");
            return (Criteria) this;
        }

        public Criteria andUserAnswerNotLike(String value) {
            addCriterion("user_answer not like", value, "userAnswer");
            return (Criteria) this;
        }

        public Criteria andUserAnswerIn(List<String> values) {
            addCriterion("user_answer in", values, "userAnswer");
            return (Criteria) this;
        }

        public Criteria andUserAnswerNotIn(List<String> values) {
            addCriterion("user_answer not in", values, "userAnswer");
            return (Criteria) this;
        }

        public Criteria andUserAnswerBetween(String value1, String value2) {
            addCriterion("user_answer between", value1, value2, "userAnswer");
            return (Criteria) this;
        }

        public Criteria andUserAnswerNotBetween(String value1, String value2) {
            addCriterion("user_answer not between", value1, value2, "userAnswer");
            return (Criteria) this;
        }

        public Criteria andGradeIsNull() {
            addCriterion("grade is null");
            return (Criteria) this;
        }

        public Criteria andGradeIsNotNull() {
            addCriterion("grade is not null");
            return (Criteria) this;
        }

        public Criteria andGradeEqualTo(String value) {
            addCriterion("grade =", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotEqualTo(String value) {
            addCriterion("grade <>", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThan(String value) {
            addCriterion("grade >", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThanOrEqualTo(String value) {
            addCriterion("grade >=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThan(String value) {
            addCriterion("grade <", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThanOrEqualTo(String value) {
            addCriterion("grade <=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLike(String value) {
            addCriterion("grade like", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotLike(String value) {
            addCriterion("grade not like", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeIn(List<String> values) {
            addCriterion("grade in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotIn(List<String> values) {
            addCriterion("grade not in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeBetween(String value1, String value2) {
            addCriterion("grade between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotBetween(String value1, String value2) {
            addCriterion("grade not between", value1, value2, "grade");
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