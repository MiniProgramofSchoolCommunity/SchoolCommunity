package SchoolCommunity.SchoolCommunityBackendNew.model;

import java.util.ArrayList;
import java.util.List;

public class ActivityNeededExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ActivityNeededExample() {
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

        public Criteria andCnameIsNull() {
            addCriterion("cname is null");
            return (Criteria) this;
        }

        public Criteria andCnameIsNotNull() {
            addCriterion("cname is not null");
            return (Criteria) this;
        }

        public Criteria andCnameEqualTo(String value) {
            addCriterion("cname =", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotEqualTo(String value) {
            addCriterion("cname <>", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameGreaterThan(String value) {
            addCriterion("cname >", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameGreaterThanOrEqualTo(String value) {
            addCriterion("cname >=", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLessThan(String value) {
            addCriterion("cname <", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLessThanOrEqualTo(String value) {
            addCriterion("cname <=", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLike(String value) {
            addCriterion("cname like", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotLike(String value) {
            addCriterion("cname not like", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameIn(List<String> values) {
            addCriterion("cname in", values, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotIn(List<String> values) {
            addCriterion("cname not in", values, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameBetween(String value1, String value2) {
            addCriterion("cname between", value1, value2, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotBetween(String value1, String value2) {
            addCriterion("cname not between", value1, value2, "cname");
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

        public Criteria andSponsorshipIsNull() {
            addCriterion("sponsorship is null");
            return (Criteria) this;
        }

        public Criteria andSponsorshipIsNotNull() {
            addCriterion("sponsorship is not null");
            return (Criteria) this;
        }

        public Criteria andSponsorshipEqualTo(String value) {
            addCriterion("sponsorship =", value, "sponsorship");
            return (Criteria) this;
        }

        public Criteria andSponsorshipNotEqualTo(String value) {
            addCriterion("sponsorship <>", value, "sponsorship");
            return (Criteria) this;
        }

        public Criteria andSponsorshipGreaterThan(String value) {
            addCriterion("sponsorship >", value, "sponsorship");
            return (Criteria) this;
        }

        public Criteria andSponsorshipGreaterThanOrEqualTo(String value) {
            addCriterion("sponsorship >=", value, "sponsorship");
            return (Criteria) this;
        }

        public Criteria andSponsorshipLessThan(String value) {
            addCriterion("sponsorship <", value, "sponsorship");
            return (Criteria) this;
        }

        public Criteria andSponsorshipLessThanOrEqualTo(String value) {
            addCriterion("sponsorship <=", value, "sponsorship");
            return (Criteria) this;
        }

        public Criteria andSponsorshipLike(String value) {
            addCriterion("sponsorship like", value, "sponsorship");
            return (Criteria) this;
        }

        public Criteria andSponsorshipNotLike(String value) {
            addCriterion("sponsorship not like", value, "sponsorship");
            return (Criteria) this;
        }

        public Criteria andSponsorshipIn(List<String> values) {
            addCriterion("sponsorship in", values, "sponsorship");
            return (Criteria) this;
        }

        public Criteria andSponsorshipNotIn(List<String> values) {
            addCriterion("sponsorship not in", values, "sponsorship");
            return (Criteria) this;
        }

        public Criteria andSponsorshipBetween(String value1, String value2) {
            addCriterion("sponsorship between", value1, value2, "sponsorship");
            return (Criteria) this;
        }

        public Criteria andSponsorshipNotBetween(String value1, String value2) {
            addCriterion("sponsorship not between", value1, value2, "sponsorship");
            return (Criteria) this;
        }

        public Criteria andCleadernameIsNull() {
            addCriterion("cleadername is null");
            return (Criteria) this;
        }

        public Criteria andCleadernameIsNotNull() {
            addCriterion("cleadername is not null");
            return (Criteria) this;
        }

        public Criteria andCleadernameEqualTo(String value) {
            addCriterion("cleadername =", value, "cleadername");
            return (Criteria) this;
        }

        public Criteria andCleadernameNotEqualTo(String value) {
            addCriterion("cleadername <>", value, "cleadername");
            return (Criteria) this;
        }

        public Criteria andCleadernameGreaterThan(String value) {
            addCriterion("cleadername >", value, "cleadername");
            return (Criteria) this;
        }

        public Criteria andCleadernameGreaterThanOrEqualTo(String value) {
            addCriterion("cleadername >=", value, "cleadername");
            return (Criteria) this;
        }

        public Criteria andCleadernameLessThan(String value) {
            addCriterion("cleadername <", value, "cleadername");
            return (Criteria) this;
        }

        public Criteria andCleadernameLessThanOrEqualTo(String value) {
            addCriterion("cleadername <=", value, "cleadername");
            return (Criteria) this;
        }

        public Criteria andCleadernameLike(String value) {
            addCriterion("cleadername like", value, "cleadername");
            return (Criteria) this;
        }

        public Criteria andCleadernameNotLike(String value) {
            addCriterion("cleadername not like", value, "cleadername");
            return (Criteria) this;
        }

        public Criteria andCleadernameIn(List<String> values) {
            addCriterion("cleadername in", values, "cleadername");
            return (Criteria) this;
        }

        public Criteria andCleadernameNotIn(List<String> values) {
            addCriterion("cleadername not in", values, "cleadername");
            return (Criteria) this;
        }

        public Criteria andCleadernameBetween(String value1, String value2) {
            addCriterion("cleadername between", value1, value2, "cleadername");
            return (Criteria) this;
        }

        public Criteria andCleadernameNotBetween(String value1, String value2) {
            addCriterion("cleadername not between", value1, value2, "cleadername");
            return (Criteria) this;
        }

        public Criteria andCleadernumIsNull() {
            addCriterion("cleadernum is null");
            return (Criteria) this;
        }

        public Criteria andCleadernumIsNotNull() {
            addCriterion("cleadernum is not null");
            return (Criteria) this;
        }

        public Criteria andCleadernumEqualTo(String value) {
            addCriterion("cleadernum =", value, "cleadernum");
            return (Criteria) this;
        }

        public Criteria andCleadernumNotEqualTo(String value) {
            addCriterion("cleadernum <>", value, "cleadernum");
            return (Criteria) this;
        }

        public Criteria andCleadernumGreaterThan(String value) {
            addCriterion("cleadernum >", value, "cleadernum");
            return (Criteria) this;
        }

        public Criteria andCleadernumGreaterThanOrEqualTo(String value) {
            addCriterion("cleadernum >=", value, "cleadernum");
            return (Criteria) this;
        }

        public Criteria andCleadernumLessThan(String value) {
            addCriterion("cleadernum <", value, "cleadernum");
            return (Criteria) this;
        }

        public Criteria andCleadernumLessThanOrEqualTo(String value) {
            addCriterion("cleadernum <=", value, "cleadernum");
            return (Criteria) this;
        }

        public Criteria andCleadernumLike(String value) {
            addCriterion("cleadernum like", value, "cleadernum");
            return (Criteria) this;
        }

        public Criteria andCleadernumNotLike(String value) {
            addCriterion("cleadernum not like", value, "cleadernum");
            return (Criteria) this;
        }

        public Criteria andCleadernumIn(List<String> values) {
            addCriterion("cleadernum in", values, "cleadernum");
            return (Criteria) this;
        }

        public Criteria andCleadernumNotIn(List<String> values) {
            addCriterion("cleadernum not in", values, "cleadernum");
            return (Criteria) this;
        }

        public Criteria andCleadernumBetween(String value1, String value2) {
            addCriterion("cleadernum between", value1, value2, "cleadernum");
            return (Criteria) this;
        }

        public Criteria andCleadernumNotBetween(String value1, String value2) {
            addCriterion("cleadernum not between", value1, value2, "cleadernum");
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