package SchoolCommunity.SchoolCommunityBackendNew.model;

import java.util.ArrayList;
import java.util.List;

public class RequirementExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RequirementExample() {
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

        public Criteria andActivityidIsNull() {
            addCriterion("activityid is null");
            return (Criteria) this;
        }

        public Criteria andActivityidIsNotNull() {
            addCriterion("activityid is not null");
            return (Criteria) this;
        }

        public Criteria andActivityidEqualTo(Long value) {
            addCriterion("activityid =", value, "activityid");
            return (Criteria) this;
        }

        public Criteria andActivityidNotEqualTo(Long value) {
            addCriterion("activityid <>", value, "activityid");
            return (Criteria) this;
        }

        public Criteria andActivityidGreaterThan(Long value) {
            addCriterion("activityid >", value, "activityid");
            return (Criteria) this;
        }

        public Criteria andActivityidGreaterThanOrEqualTo(Long value) {
            addCriterion("activityid >=", value, "activityid");
            return (Criteria) this;
        }

        public Criteria andActivityidLessThan(Long value) {
            addCriterion("activityid <", value, "activityid");
            return (Criteria) this;
        }

        public Criteria andActivityidLessThanOrEqualTo(Long value) {
            addCriterion("activityid <=", value, "activityid");
            return (Criteria) this;
        }

        public Criteria andActivityidIn(List<Long> values) {
            addCriterion("activityid in", values, "activityid");
            return (Criteria) this;
        }

        public Criteria andActivityidNotIn(List<Long> values) {
            addCriterion("activityid not in", values, "activityid");
            return (Criteria) this;
        }

        public Criteria andActivityidBetween(Long value1, Long value2) {
            addCriterion("activityid between", value1, value2, "activityid");
            return (Criteria) this;
        }

        public Criteria andActivityidNotBetween(Long value1, Long value2) {
            addCriterion("activityid not between", value1, value2, "activityid");
            return (Criteria) this;
        }

        public Criteria andRequirementIsNull() {
            addCriterion("requirement is null");
            return (Criteria) this;
        }

        public Criteria andRequirementIsNotNull() {
            addCriterion("requirement is not null");
            return (Criteria) this;
        }

        public Criteria andRequirementEqualTo(String value) {
            addCriterion("requirement =", value, "requirement");
            return (Criteria) this;
        }

        public Criteria andRequirementNotEqualTo(String value) {
            addCriterion("requirement <>", value, "requirement");
            return (Criteria) this;
        }

        public Criteria andRequirementGreaterThan(String value) {
            addCriterion("requirement >", value, "requirement");
            return (Criteria) this;
        }

        public Criteria andRequirementGreaterThanOrEqualTo(String value) {
            addCriterion("requirement >=", value, "requirement");
            return (Criteria) this;
        }

        public Criteria andRequirementLessThan(String value) {
            addCriterion("requirement <", value, "requirement");
            return (Criteria) this;
        }

        public Criteria andRequirementLessThanOrEqualTo(String value) {
            addCriterion("requirement <=", value, "requirement");
            return (Criteria) this;
        }

        public Criteria andRequirementLike(String value) {
            addCriterion("requirement like", value, "requirement");
            return (Criteria) this;
        }

        public Criteria andRequirementNotLike(String value) {
            addCriterion("requirement not like", value, "requirement");
            return (Criteria) this;
        }

        public Criteria andRequirementIn(List<String> values) {
            addCriterion("requirement in", values, "requirement");
            return (Criteria) this;
        }

        public Criteria andRequirementNotIn(List<String> values) {
            addCriterion("requirement not in", values, "requirement");
            return (Criteria) this;
        }

        public Criteria andRequirementBetween(String value1, String value2) {
            addCriterion("requirement between", value1, value2, "requirement");
            return (Criteria) this;
        }

        public Criteria andRequirementNotBetween(String value1, String value2) {
            addCriterion("requirement not between", value1, value2, "requirement");
            return (Criteria) this;
        }

        public Criteria andSnameIsNull() {
            addCriterion("sname is null");
            return (Criteria) this;
        }

        public Criteria andSnameIsNotNull() {
            addCriterion("sname is not null");
            return (Criteria) this;
        }

        public Criteria andSnameEqualTo(String value) {
            addCriterion("sname =", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotEqualTo(String value) {
            addCriterion("sname <>", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameGreaterThan(String value) {
            addCriterion("sname >", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameGreaterThanOrEqualTo(String value) {
            addCriterion("sname >=", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameLessThan(String value) {
            addCriterion("sname <", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameLessThanOrEqualTo(String value) {
            addCriterion("sname <=", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameLike(String value) {
            addCriterion("sname like", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotLike(String value) {
            addCriterion("sname not like", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameIn(List<String> values) {
            addCriterion("sname in", values, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotIn(List<String> values) {
            addCriterion("sname not in", values, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameBetween(String value1, String value2) {
            addCriterion("sname between", value1, value2, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotBetween(String value1, String value2) {
            addCriterion("sname not between", value1, value2, "sname");
            return (Criteria) this;
        }

        public Criteria andSlevelIsNull() {
            addCriterion("slevel is null");
            return (Criteria) this;
        }

        public Criteria andSlevelIsNotNull() {
            addCriterion("slevel is not null");
            return (Criteria) this;
        }

        public Criteria andSlevelEqualTo(Integer value) {
            addCriterion("slevel =", value, "slevel");
            return (Criteria) this;
        }

        public Criteria andSlevelNotEqualTo(Integer value) {
            addCriterion("slevel <>", value, "slevel");
            return (Criteria) this;
        }

        public Criteria andSlevelGreaterThan(Integer value) {
            addCriterion("slevel >", value, "slevel");
            return (Criteria) this;
        }

        public Criteria andSlevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("slevel >=", value, "slevel");
            return (Criteria) this;
        }

        public Criteria andSlevelLessThan(Integer value) {
            addCriterion("slevel <", value, "slevel");
            return (Criteria) this;
        }

        public Criteria andSlevelLessThanOrEqualTo(Integer value) {
            addCriterion("slevel <=", value, "slevel");
            return (Criteria) this;
        }

        public Criteria andSlevelIn(List<Integer> values) {
            addCriterion("slevel in", values, "slevel");
            return (Criteria) this;
        }

        public Criteria andSlevelNotIn(List<Integer> values) {
            addCriterion("slevel not in", values, "slevel");
            return (Criteria) this;
        }

        public Criteria andSlevelBetween(Integer value1, Integer value2) {
            addCriterion("slevel between", value1, value2, "slevel");
            return (Criteria) this;
        }

        public Criteria andSlevelNotBetween(Integer value1, Integer value2) {
            addCriterion("slevel not between", value1, value2, "slevel");
            return (Criteria) this;
        }

        public Criteria andSleadernameIsNull() {
            addCriterion("sleadername is null");
            return (Criteria) this;
        }

        public Criteria andSleadernameIsNotNull() {
            addCriterion("sleadername is not null");
            return (Criteria) this;
        }

        public Criteria andSleadernameEqualTo(String value) {
            addCriterion("sleadername =", value, "sleadername");
            return (Criteria) this;
        }

        public Criteria andSleadernameNotEqualTo(String value) {
            addCriterion("sleadername <>", value, "sleadername");
            return (Criteria) this;
        }

        public Criteria andSleadernameGreaterThan(String value) {
            addCriterion("sleadername >", value, "sleadername");
            return (Criteria) this;
        }

        public Criteria andSleadernameGreaterThanOrEqualTo(String value) {
            addCriterion("sleadername >=", value, "sleadername");
            return (Criteria) this;
        }

        public Criteria andSleadernameLessThan(String value) {
            addCriterion("sleadername <", value, "sleadername");
            return (Criteria) this;
        }

        public Criteria andSleadernameLessThanOrEqualTo(String value) {
            addCriterion("sleadername <=", value, "sleadername");
            return (Criteria) this;
        }

        public Criteria andSleadernameLike(String value) {
            addCriterion("sleadername like", value, "sleadername");
            return (Criteria) this;
        }

        public Criteria andSleadernameNotLike(String value) {
            addCriterion("sleadername not like", value, "sleadername");
            return (Criteria) this;
        }

        public Criteria andSleadernameIn(List<String> values) {
            addCriterion("sleadername in", values, "sleadername");
            return (Criteria) this;
        }

        public Criteria andSleadernameNotIn(List<String> values) {
            addCriterion("sleadername not in", values, "sleadername");
            return (Criteria) this;
        }

        public Criteria andSleadernameBetween(String value1, String value2) {
            addCriterion("sleadername between", value1, value2, "sleadername");
            return (Criteria) this;
        }

        public Criteria andSleadernameNotBetween(String value1, String value2) {
            addCriterion("sleadername not between", value1, value2, "sleadername");
            return (Criteria) this;
        }

        public Criteria andSleadernumIsNull() {
            addCriterion("sleadernum is null");
            return (Criteria) this;
        }

        public Criteria andSleadernumIsNotNull() {
            addCriterion("sleadernum is not null");
            return (Criteria) this;
        }

        public Criteria andSleadernumEqualTo(String value) {
            addCriterion("sleadernum =", value, "sleadernum");
            return (Criteria) this;
        }

        public Criteria andSleadernumNotEqualTo(String value) {
            addCriterion("sleadernum <>", value, "sleadernum");
            return (Criteria) this;
        }

        public Criteria andSleadernumGreaterThan(String value) {
            addCriterion("sleadernum >", value, "sleadernum");
            return (Criteria) this;
        }

        public Criteria andSleadernumGreaterThanOrEqualTo(String value) {
            addCriterion("sleadernum >=", value, "sleadernum");
            return (Criteria) this;
        }

        public Criteria andSleadernumLessThan(String value) {
            addCriterion("sleadernum <", value, "sleadernum");
            return (Criteria) this;
        }

        public Criteria andSleadernumLessThanOrEqualTo(String value) {
            addCriterion("sleadernum <=", value, "sleadernum");
            return (Criteria) this;
        }

        public Criteria andSleadernumLike(String value) {
            addCriterion("sleadernum like", value, "sleadernum");
            return (Criteria) this;
        }

        public Criteria andSleadernumNotLike(String value) {
            addCriterion("sleadernum not like", value, "sleadernum");
            return (Criteria) this;
        }

        public Criteria andSleadernumIn(List<String> values) {
            addCriterion("sleadernum in", values, "sleadernum");
            return (Criteria) this;
        }

        public Criteria andSleadernumNotIn(List<String> values) {
            addCriterion("sleadernum not in", values, "sleadernum");
            return (Criteria) this;
        }

        public Criteria andSleadernumBetween(String value1, String value2) {
            addCriterion("sleadernum between", value1, value2, "sleadernum");
            return (Criteria) this;
        }

        public Criteria andSleadernumNotBetween(String value1, String value2) {
            addCriterion("sleadernum not between", value1, value2, "sleadernum");
            return (Criteria) this;
        }

        public Criteria andContactsnameIsNull() {
            addCriterion("contactsname is null");
            return (Criteria) this;
        }

        public Criteria andContactsnameIsNotNull() {
            addCriterion("contactsname is not null");
            return (Criteria) this;
        }

        public Criteria andContactsnameEqualTo(String value) {
            addCriterion("contactsname =", value, "contactsname");
            return (Criteria) this;
        }

        public Criteria andContactsnameNotEqualTo(String value) {
            addCriterion("contactsname <>", value, "contactsname");
            return (Criteria) this;
        }

        public Criteria andContactsnameGreaterThan(String value) {
            addCriterion("contactsname >", value, "contactsname");
            return (Criteria) this;
        }

        public Criteria andContactsnameGreaterThanOrEqualTo(String value) {
            addCriterion("contactsname >=", value, "contactsname");
            return (Criteria) this;
        }

        public Criteria andContactsnameLessThan(String value) {
            addCriterion("contactsname <", value, "contactsname");
            return (Criteria) this;
        }

        public Criteria andContactsnameLessThanOrEqualTo(String value) {
            addCriterion("contactsname <=", value, "contactsname");
            return (Criteria) this;
        }

        public Criteria andContactsnameLike(String value) {
            addCriterion("contactsname like", value, "contactsname");
            return (Criteria) this;
        }

        public Criteria andContactsnameNotLike(String value) {
            addCriterion("contactsname not like", value, "contactsname");
            return (Criteria) this;
        }

        public Criteria andContactsnameIn(List<String> values) {
            addCriterion("contactsname in", values, "contactsname");
            return (Criteria) this;
        }

        public Criteria andContactsnameNotIn(List<String> values) {
            addCriterion("contactsname not in", values, "contactsname");
            return (Criteria) this;
        }

        public Criteria andContactsnameBetween(String value1, String value2) {
            addCriterion("contactsname between", value1, value2, "contactsname");
            return (Criteria) this;
        }

        public Criteria andContactsnameNotBetween(String value1, String value2) {
            addCriterion("contactsname not between", value1, value2, "contactsname");
            return (Criteria) this;
        }

        public Criteria andContactsnumIsNull() {
            addCriterion("contactsnum is null");
            return (Criteria) this;
        }

        public Criteria andContactsnumIsNotNull() {
            addCriterion("contactsnum is not null");
            return (Criteria) this;
        }

        public Criteria andContactsnumEqualTo(String value) {
            addCriterion("contactsnum =", value, "contactsnum");
            return (Criteria) this;
        }

        public Criteria andContactsnumNotEqualTo(String value) {
            addCriterion("contactsnum <>", value, "contactsnum");
            return (Criteria) this;
        }

        public Criteria andContactsnumGreaterThan(String value) {
            addCriterion("contactsnum >", value, "contactsnum");
            return (Criteria) this;
        }

        public Criteria andContactsnumGreaterThanOrEqualTo(String value) {
            addCriterion("contactsnum >=", value, "contactsnum");
            return (Criteria) this;
        }

        public Criteria andContactsnumLessThan(String value) {
            addCriterion("contactsnum <", value, "contactsnum");
            return (Criteria) this;
        }

        public Criteria andContactsnumLessThanOrEqualTo(String value) {
            addCriterion("contactsnum <=", value, "contactsnum");
            return (Criteria) this;
        }

        public Criteria andContactsnumLike(String value) {
            addCriterion("contactsnum like", value, "contactsnum");
            return (Criteria) this;
        }

        public Criteria andContactsnumNotLike(String value) {
            addCriterion("contactsnum not like", value, "contactsnum");
            return (Criteria) this;
        }

        public Criteria andContactsnumIn(List<String> values) {
            addCriterion("contactsnum in", values, "contactsnum");
            return (Criteria) this;
        }

        public Criteria andContactsnumNotIn(List<String> values) {
            addCriterion("contactsnum not in", values, "contactsnum");
            return (Criteria) this;
        }

        public Criteria andContactsnumBetween(String value1, String value2) {
            addCriterion("contactsnum between", value1, value2, "contactsnum");
            return (Criteria) this;
        }

        public Criteria andContactsnumNotBetween(String value1, String value2) {
            addCriterion("contactsnum not between", value1, value2, "contactsnum");
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